package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * 동적계획법을 이용해 최소합이 되는 경로 구하기.
 *
 * BottomUp 방식을 이용!
 *
 * 조건: 1. 이동은 오른쪽 혹은 아래쪽으로 밖에 이동하지 못한다.
 *      2. 최소합이 되는 경로를 찾아야 한다.
 *
 *  표는 아래와 같다.
 *
 *  | 6 | 7  | 12 | 5  |
 *  | 5 | 3  | 11 | 18 |
 *  | 7 | 17 | 3  | 3  |
 *  | 8 | 10 | 14 | 9  |
 *
 * 그렇기 때문에 위쪽이나 왼쪽까지 최소경로로 온 값 + 현재 위치 값을 하면 최소 경로 값이 된다.
 * */
public class FindPathByBottomUp {

    private int[][] map;
    private int[][] memoization;

    public FindPathByBottomUp(){
        map = new int[][]{{6,7,12,5},{5,3,11,18},{7,17,3,3},{8,10,14,9}};
        memoization = new int[4][4];
    }

    public int minSumPath(int verticalLength, int horizonLength){
        /** verticalLength : map의 세로 길이
         *  horizonLength : map의 가로 길이
         * */
        for(int i=0; i<=verticalLength; i++){
            for(int j=0; j<=horizonLength; j++){

                if(i==0 && j==0){
                    memoization[i][j] = map[i][j];
                }else if(i==0){
                    memoization[i][j] = memoization[i][j-1]+map[i][j];
                }else if(j==0){
                    memoization[i][j] = memoization[i-1][j]+map[i][j];
                }else{
                    memoization[i][j] = Math.min(memoization[i-1][j], memoization[i][j-1]) + map[i][j];
                }
            }
        }

        return memoization[verticalLength][horizonLength];

    }



    public static void main(String[] args){
        FindPathByBottomUp findPath = new FindPathByBottomUp();
        System.out.println("최소 경로의 합 : "+findPath.minSumPath(3,3));

    }
}
