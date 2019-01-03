package com.algorithm.studyAlgorithm.dynamicProgramming;

import java.util.*;

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
