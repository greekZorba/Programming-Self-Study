package com.algorithm.studyAlgorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/********************************************************************
 *
 * 너비우선탐색(bfs)
 * 보통 인접배열 방식으로 이차원배열을 활용해서 구현함
 * 그래서 이차원배열로 구현해보았다.
 *
 * 인접한 배열이 있으면 1을 표시
 * distancePath 배열에서 -1은 방문하지 않음을 의미
 *
 * distancePath[찾고자하는 노드]는 시작한 부분으로부터 찾고자하는 노드까지의 최단 거리
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *********************************************************************/
public class BreadthFirstSearch {

    public static void main(String[] args){
        /** 인덱스를 1부터 시작함, -1들은 무시하면 되는 공간 */
        int[][] adjacencyMatrix = new int[][]{
                {-1,-1,-1,-1,-1},
                {-1,0,1,1,0},
                {-1,1,0,0,1},
                {-1,1,0,0,1},
                {-1,0,1,1,0}
        };
        int startPoint = 2;
        int findPoint = 4;

        bfs(adjacencyMatrix, startPoint, findPoint);
    }

    private static void bfs(int[][] adjacencyMatrix, int startPoint, int findPoint){

        /** 요소들을 담을 큐 */
        Queue<Integer> queue = new ArrayDeque<>();

        /** 찾는 노드의 최단 경로를 구할 것임 */
        int[] distancePath = new int[adjacencyMatrix.length];
        Arrays.fill(distancePath, -1);

        /** 찾는 노드의 직전 노드 */
        int[] predecessor = new int[adjacencyMatrix.length];

        queue.add(startPoint);
        /**시작 포인트는 방문했음을 의미함과 동시에 시작포인트에서의 거리가 0이라서 0을 대입 */
        distancePath[startPoint] = 0;

        while(!queue.isEmpty()){

            int node = queue.poll();
            System.out.println("bfs 읽기 : "+node);
            for(int i=1; i<adjacencyMatrix.length; i++){

                if(adjacencyMatrix[node][i] == 1 && distancePath[i] == -1){
                    distancePath[i] = distancePath[node]+1;
                    predecessor[i] = node;
                    queue.add(i);
                }
            }
        }

        System.out.println("찾고자하는 포인트: "+findPoint+" 시작점으로부터 찾고자하는 포인트까지의 거리 : "+distancePath[findPoint]);
        System.out.println("찾고자하는 포인트의 predecessor: "+ predecessor[findPoint]);


    }



}
