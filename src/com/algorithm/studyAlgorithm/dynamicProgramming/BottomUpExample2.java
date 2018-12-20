package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * 이항계수를 이용해 BottomUp을 구현하는 방법이다.
 * 이항계수란 주어진 크기의(순서 없는) 조합의 가짓수이다.
 *
 * nCk = (n) 즉, n개 중 k를 선택할 경우의 수이다.
 *       (k)
 *
 * (n) = { 1                if n=k or k=0
 * (k)   { (n-1) + (n-1)    otherwise
 *         ( k )   (k-1)    왜냐면 n에서 k를 제외하면 n-1 크기를 가진다. n-1에서 k를 선택할 경우와 안할 경우를 합하면
 *                          nCk의 경우의 수와 같다.
 *
 *  nCk를 구하는 공식: n!/(n-k)!k!
 * */
public class BottomUpExample2 {

    private static int[][] rememberBinomial;

    public BottomUpExample2(int n, int k){
        rememberBinomial = new int[n+1][k+1];
    }

    private int bottomUpBinomial(int n, int k){

        /** i가 n값을, j가 k값을 대변한다고 볼 수 있다. */
        for(int i=0; i<=n; i++){
            for(int j=0; j<=k && j<=i; j++){

                if(j==0 || j == i){
                    rememberBinomial[i][j] = 1;
                }else{
                    rememberBinomial[i][j] = rememberBinomial[i-1][j-1]+ rememberBinomial[i-1][j];
                }
            }
        }

        return rememberBinomial[n][k];
    }

    public static void main(String[] args){
        int n = 5;
        int k = 2;
        BottomUpExample2 bottomUp = new BottomUpExample2(n, k);
        System.out.println("BottomUp을 활용해서 나온 이항계수 결과 값 : "+bottomUp.bottomUpBinomial(n,k));

        System.out.println("--- 이차원배열로 그려진 이항계수 모습 ---");
        for(int i=0; i<rememberBinomial.length; i++){

            for(int j=0; j<rememberBinomial[0].length; j++){
                System.out.print(rememberBinomial[i][j]+" ");
            }
            System.out.println();
        }
    }

}
