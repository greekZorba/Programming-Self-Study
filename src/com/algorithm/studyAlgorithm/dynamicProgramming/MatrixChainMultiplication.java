package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * Matrix-chain Multiplication 행렬 체인 곱하기
 *
 * p*q 행렬 A와 q*r 행렬 B를 곱하면 p*r형태의 행렬이 생김
 * 곱셈의 총 연산횟수는 pqr이다.
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

    public static void main(String[] args){
        int[][] A = new int[][]{{2,3},{4,2}};
        int[][] B = new int[][]{{1,3,5},{3,2,6}};
        MatrixChainMultiplication matrixChain = new MatrixChainMultiplication();
        int[][] C = matrixChain.multiplyMatrix(A,B);

        for(int i=0; i<C.length; i++){
            System.out.println();
            for(int j=0; j<C[0].length; j++){
                System.out.print(C[i][j] + " ");
            }
        }
    }


}
