package com.algorithm.studyAlgorithm.dynamicProgramming;

import java.util.*;

/**
 * Longest Common Subsequence(최장 공통 부분 수열) - 줄여서 LCS
 * 주어진 여러개의 수열 모두의 부분수열이 되는 수열들 중에 가장 긴 것을 찾는 문제이다.
 *
 * <bcdb>는 문자열 <abcbdab>의 subsequence이다.
 * <bca>는 문자열 <abcbdab>와 <bdcaba>의 common subsequence이다.
 * 여기서 LCS는
 * common subsequence들 중 가장 긴 것이다.
 * <bcba>는 <abcbdab>와 <bdcaba>의 LCS이다.
 *
 * 예시)
 * L[i,j] : 문자열 X = {x1, x2, x3 .. xi} 와 Y = {y1, y2, y3 ... yj}의 LCS의 길이
 * L이 이차원배열이기 때문에 L의 행은 X 문자열의 나열, 열은 Y 문자열의 나열로 생각하면 된다.(그 반대도 상관없다)
 * 그리고 행(X)과 열(Y)에 있는 문자열을 비교해서 LCS의 길이를 구한다고 생각하자.
 * 문자열을 각각 뒤에서부터 비교하기 시작한다. 아래의 xi, yj부터.
 *
 * X = x1 x2 x3 ... x(i-1) xi
 * Y = y1 y2 y3 ... y(j-2) y(j-1) yj
 *
 * case 1
 * xi 와 yj가 매칭되면 (xi = yj)
 * L[i,j] = L[i-1, j-1] + 1
 * x(i-1), y(j-1)까지의 LCS 길이에서 +1을 해준 것과 같다.
 *
 * case 2
 * xi와 yj가 같지 않다면 (xi != yj) 둘 중 하나는 버리고 진행해야 한다.
 * L[i,j] = MAX(L[i-1,j], L[i,j-1])
 * 둘 중 하나를 버렸을 때 LCS가 가장 긴 값을 가지는 수를 선택하고 다른 문자를 버린다.
 *
 * 순환식
 *        -> 0                        if i = 0 or j = 0
 * L[i,j] -> L[i-1,j-1] + 1           if xi = yj
 *        -> MAX(L[i-1,j], L[i,j-1])  otherwise
 * */

public class LongestCommonSubsequence {

    private int[][] L;

    private String[] X;

    private String[] Y;

    public LongestCommonSubsequence(){
        X = new String[]{"a","b","c","b","d","a","b"};
        Y = new String[]{"b","d","c","a","b","a"};

        L = new int[X.length][Y.length];
        for(int i=0; i<L.length; i++){
            for(int j=0; j<L[0].length; j++){
                L[i][j] = -1;
            }
        }

    }

    private int calculateLengthOfLCSByRecursive(int lengthOfX, int lengthOfY){

        if(lengthOfX < 0 || lengthOfY < 0){
            return 0;
        }
        else if(L[lengthOfX][lengthOfY] != -1){
            return L[lengthOfX][lengthOfY];
        }
        else if(X[lengthOfX].equals(Y[lengthOfY])){
            L[lengthOfX][lengthOfY] = calculateLengthOfLCSByRecursive(lengthOfX-1, lengthOfY-1)+1;
            return L[lengthOfX][lengthOfY];

        }
        else{
            L[lengthOfX][lengthOfY] = Math.max(calculateLengthOfLCSByRecursive(lengthOfX-1, lengthOfY),
                    calculateLengthOfLCSByRecursive(lengthOfX, lengthOfY-1));
            return L[lengthOfX][lengthOfY];
        }

    }

    private int calculateLengthOfLCSByBottomUp(int lengthOfX, int lengthOfY){
        L = new int[lengthOfX+1][lengthOfY+1];

        for(int i=0; i<=lengthOfX; i++){
            for(int j=0; j<=lengthOfY; j++){

                if(i == 0 || j == 0){
                    L[i][j] = 0;
                }
                else if(X[i-1].equals(Y[j-1])){
                    L[i][j] = L[i-1][j-1] + 1;
                }
                else{
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
                }
            }
        }

        return L[lengthOfX][lengthOfY];
    }

    public String[] getX(){
        return this.X;
    }

    public String[] getY(){
        return this.Y;
    }


    public static void main(String[] args){
        LongestCommonSubsequence LCS = new LongestCommonSubsequence();
        System.out.println("최장 공통 부분 수열(재귀 사용) : ");
        System.out.println(LCS.calculateLengthOfLCSByRecursive(LCS.getX().length-1,
                LCS.getY().length-1));

        System.out.println("최장 공통 부분 수열(bottom up 사용) : ");
        System.out.println(LCS.calculateLengthOfLCSByBottomUp(LCS.getX().length,
                LCS.getY().length));
    }
}
