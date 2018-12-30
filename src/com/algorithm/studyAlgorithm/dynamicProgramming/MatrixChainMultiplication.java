package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * Matrix-chain Multiplication 행렬 체인 곱하기
 *
 * p*q 행렬 A와 q*r 행렬 B를 곱하면 p*r형태의 행렬이 생김
 * 곱셈의 총 연산횟수는 pqr이다.
 *
 * 행렬 A ( 2 3 )
 *       ( 4 2 )
 *
 * 행렬 B ( 1 3 5 )
 *       ( 3 2 6 )
 *
 * 행렬 C = A*B
 * ( 2*1+3*3  2*3+3*2  2*5+3*6 ) == ( 11 12 28 )
 * ( 4*1+2*3  4*3+2*2  4*5+2*6 )    ( 10 16 32 )
 *
 * 단순하게 행렬 곱의 결과를 구하는 메서드 multiplyMatrix
 *
 *
 *
 *
 *
 *
 *
 * 행렬의 곱에서는 교환법칙은 성립하지 않지만, 결합 법칙이 성립한다.
 * 행렬 A(10*100), B(100*5), C(5*50)가 있다면,
 * (AB)C == A(BC) 모두 결과값이 같다.
 *
 * 하지만 연산횟수가 다르다.
 * (AB)C는 7,500번 (10*100*5 + 10*5*50)
 * A(BC)는 75,000번 (100*5*50 + 10*100*50)
 *
 * A1*A2*A3*A4 ... *An을 계산하는 최적의 순서를 통해 연산횟수가 얼마나 되는가.
 *
 * A1*A2*A3 ... *Ak ~ A(k+1)*A(k+2)*...*An
 * \            /    \                 /
 *  X(곱의 연산횟수)        Y(곱의 연산횟수)
 *        \                    /
 *         Z(두 행렬의 X, Y의 곱이다)
 *
 * 행렬 Ai는 P(i-1) * P(i)라는 공간을 가진다.
 * A1(3*10) * A2(10*4)일 때 A1은 P[0)*P[1] , P[0]은 3, P[1]은 10이다.
 * 아래의 P(i-1)*Pk*Pj 공식은 X와 Y행렬을 곱하면서 발생하는 곱셈횟수이다.
 *
 * m[i,j] : Ai A(i+1)... Aj를 곱하는 최소곱셈 횟수
 * m[i,j] -> 0 if i=j
 *       |
 *        -> MIN i<=k<=j-1(m[i,k] + m[k+1,j] + P(i-1)*Pk*Pj) if i<j
 *
 *   1    2    3    4    5    6
 * 1 0 | [] | [] | [] | [] | []
 * 2   | 0  | [] | [] | [] | []
 * 3   |    | 0  | [] | [] | []
 * 4   |    |    | 0  | [] | []
 * 5   |    |    |    | 0  | []
 * 6   |    |    |    |    | 0
 *
 * 오른쪽 대각선으로 내려가면서 계산한다.
 * 최적의 순서를 구해서 최소 연산횟수를 알수 있는 메서드 maxtrixChain을 통해 구현.
 * 시간복잡도 : O(n^3)
 * * */
public class MatrixChainMultiplication {

    private int[][] multiplyMatrix(int[][] A, int[][] B){
        int[][] C = new int[A.length][B[0].length];

        for(int i=0; i<A.length; i++){ // 주석의 p
            for(int j=0; j<B[0].length; j++){ // 주석의 r
                C[i][j] = 0;
                for(int k=0; k<A[0].length; k++){ // 주석의 q
                    C[i][j] += A[i][k]*B[k][j];
                }
            }
        }

        return C;
    }

    private int matrixChain(int[] dimension, int n){
        int[][] m = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            m[i][i] = 0;
        }

        for(int r=1; r<=n-1; r++){ // 이차원배열의 열 끝까지 계산
            for(int i=1; i<=n-r; i++){ // 오른쪽 대각선으로 내려가면서 계산할 때 연산 횟수
                int j = i+r;
                m[i][j] = m[i+1][j] + dimension[i-1]*dimension[i]*dimension[j]; // 최초 m[i][i]가 0이기 때문

                for(int k = i+1; k<=j-1; k++){
                    if(m[i][j]> m[i][k] + m[k+1][j] + dimension[i-1]*dimension[k]*dimension[j]){
                        m[i][j] = m[i][k] + m[k+1][j] + dimension[i-1]*dimension[k]*dimension[j];
                    }
                }
            }
        }

        for(int i=1; i<m.length; i++){
            System.out.println();
            for(int j=1; j<m[0].length; j++){
                System.out.print(m[i][j] + " ");
            }
        }

        return m[1][n];
    }

    public static void main(String[] args){
        int[][] A = new int[][]{{2,3},{4,2}};
        int[][] B = new int[][]{{1,3,5},{3,2,6}};
        MatrixChainMultiplication matrixChain = new MatrixChainMultiplication();
        int[][] C = matrixChain.multiplyMatrix(A,B);

        System.out.print("단순 행렬 곱 결과 :");
        for(int i=0; i<C.length; i++){
            System.out.println();
            for(int j=0; j<C[0].length; j++){
                System.out.print(C[i][j] + " ");
            }
        }
        System.out.println();

        int[] dimension = new int[]{10,100,5,50};
        int n = 3;
        System.out.println("최소 곱셈 횟수 : "+matrixChain.matrixChain(dimension,n));
    }


}
