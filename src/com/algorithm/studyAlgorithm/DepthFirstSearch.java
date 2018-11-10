package com.algorithm.studyAlgorithm;

import java.util.Arrays;

/********************************************************************
 *
 * 깊이우선탐색(dfs)
 * 보통 인접배열 방식으로 이차원배열을 활용해서 구현함
 * 그래서 이차원배열로 구현해보았다.
 *
 * 아래의 예시 그림으로 그리면?
 *
 *              1    7
 *             / \ / |
 *            2   3  |
 *           / \ / \ |
 *          4   5   8
 *              |
 *              6
 *
 * 개념 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *********************************************************************/
public class DepthFirstSearch {

    public static void main(String[] args){
        /** for starting index from 1, just ignore -1
         *  1 means there is node, 0 means there is not node
         * */
        int[][] adjacencyMatrix = new int[][]{
                {-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,0,1,1,0,0,0,0,0},
                {-1,1,0,0,1,1,0,0,0},
                {-1,1,0,0,0,1,0,1,1},
                {-1,0,1,0,0,1,0,0,0},
                {-1,0,1,1,1,0,1,0,0},
                {-1,0,0,0,0,1,0,0,0},
                {-1,0,0,1,0,0,0,0,1},
                {-1,0,0,1,0,0,0,1,0}
        };
        int startPoint = 1;
        boolean[] visitied = new boolean[adjacencyMatrix.length];

        /** all init value is unvisited */
        Arrays.fill(visitied, false);

        dfs(adjacencyMatrix, visitied, startPoint);
    }

    private static void dfs(int[][] adjacencyMatrix, boolean[] visited, int node){

        visited[node] = true;
        System.out.println("reading dfs : "+node);

        for(int i=1; i<adjacencyMatrix.length; i++){

            if(adjacencyMatrix[node][i] == 1 && !visited[i]){
                dfs(adjacencyMatrix, visited, i);
            }
        }
    }
}
