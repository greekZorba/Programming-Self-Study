package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * 동적계획법을 이용해 최소합이 되는 경로 구하기.
 *
 * 재귀 방식을 이용!
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
public class FindPathByRecursive {

    private int[][] map;
    private int[][] memoization;
    private static final int START_POINT = 1;
    private static final int FROM_LEFT_DIRECTION = 2;
    private static final int FROM_UP_DIRECTION = 3;
    private int[][] path;

    public FindPathByRecursive(){
        map = new int[][]{{6,7,12,5},{5,3,11,18},{7,17,3,3},{8,10,14,9}};
        memoization = new int[4][4];
        path = new int[4][4];
    }

    public int minSumPath(int i, int j){

        if(memoization[i][j] != 0){
            return memoization[i][j];
        }

        if(i==0 && j==0){
            memoization[i][j] = map[i][j];
            path[i][j] = START_POINT;
        }else if(i==0){
            memoization[i][j] = minSumPath(i,j-1)+map[i][j];
            path[i][j] = FROM_LEFT_DIRECTION;
        }else if(j==0){
            memoization[i][j] = minSumPath(i-1, j)+map[i][j];
            path[i][j] = FROM_UP_DIRECTION;
        }else{
            if(minSumPath(i-1, j) > minSumPath(i, j-1)){
                memoization[i][j] = minSumPath(i, j-1) + map[i][j];
                path[i][j] = FROM_LEFT_DIRECTION;
            }else{
                memoization[i][j] = minSumPath(i-1, j) + map[i][j];
                path[i][j] = FROM_UP_DIRECTION;
            }
        }
        return memoization[i][j];

    }

    public void printReversePath(int i, int j){

        while(path[i][j] != START_POINT){
            System.out.print(i+","+ j+" => ");
            if(path[i][j]==FROM_LEFT_DIRECTION){
                j = j-1;
            }else{
                i = i-1;
            }
        }
        System.out.println(i+","+j);
    }

    public void printPath(int i, int j){

        if(path[i][j]==START_POINT){
            System.out.print(i+","+j+" => ");
        }else{

            if(path[i][j]==FROM_LEFT_DIRECTION){
                printPath(i,j-1);
            }else{
                printPath(i-1,j);
            }
            System.out.print(i+ ","+j+" => ");
        }
    }



    public static void main(String[] args){
        FindPathByRecursive findPath = new FindPathByRecursive();
        System.out.println("최소 경로의 합 : "+findPath.minSumPath(3,3));
        System.out.println("역방향 경로 --------");
        findPath.printReversePath(3,3);
        System.out.println("정방향 경로 --------");
        findPath.printPath(3,3);

    }
}
