package com.algorithm.studyAlgorithm;

import java.util.Arrays;

/********************************************************************
 *
 * 너비우선탐색(bfs)
 * 보통 인접배열 방식으로 이차원배열을 활용해서 구현함
 * 그래서 이차원배열로 구현해보았다.
 *
 * 인접한 배열이 있으면 1을 표시
 * visited 배열에서 -1은 방문하지 않음을 의미
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class BreadthFirstSearch {

    public static void main(String[] args){
        /** 인덱스를 1부터 시작함, -1들은 무시하면 되는 공간 */
        int[][] adjacencyMatrix = new int[][]{
                {-1,-1,-1,-1,-1},
                {-1,0,1,1,1},
                {-1,1,0,0,1},
                {-1,1,0,0,1},
                {-1,1,1,1,0}
        };

    }

    private static void bfs(int[][] adjacencyMatrix){

        /** 찾는 노드의 최단 경로를 구할 것임 */
        int[] visited = new int[adjacencyMatrix.length];
        Arrays.fill(visited, -1);

        /** 찾는 노드의 직전 노드 */
        int[] predecessor = new int[adjacencyMatrix.length];

        for(int i=1; i<adjacencyMatrix.length; i++){

        }
    }



}
