package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * knapsack problem
 * 가방 안에 최대한 높은 값을 한정된 양만큼 넣는 방법이다.
 *
 * 예를 들어, 강도가 들었을 때 그가 가진 가방에 들어가는 양만큼
 * 최대한 비싼 물건을 담아야한다.
 *
 * 배낭의 용량은 초과하지 않으면서 최대가 되는 부분 집합
 *
 * i는 순서, Vi는 가격,가치 Wi는 무게를 의미함.
 *
 * i | Vi | Wi
 * -----------
 * 1 | 1  | 2
 * 2 | 6  | 2
 * 3 | 18 | 5
 * 4 | 22 | 6
 * 5 | 28 | 7
 *
 * OPT(i, w): 배낭 용량이 w일 때 아이템 1,2,...,i로 얻는 최대 이득
 * 경우 1 : 아이템 i를 선택하지 않는 경우
 *         OPT(i, w) = OPT(i-1, w)
 *
 * 경우 2 : 아이템 i를 선택하는 경우(넣을 수 있는 잔여무게보다 넣으려는 아이템의 무게가 더 크면 넣을 수 없다)
 *         OPT(i) = OPT(i-1, w-wi) + Vi
 *
 * 순환식
 *           -> 0               if i=0
 * OPT(i, w) -> OPT(i-1, w)     if Wi > W (잔여무게보다 넣으려는 아이템의 무게가 클 )
 *           -> max(OPT(i-1, w), OPT(i-1, w-Wi)+Vi ) Otherwise
 * */
public class KnapsackProblem {


    private int[][] knapsack(int index, int weight, int[][] exampleTable){
        int[][] maxKnapsack = new int[index+1][weight+1];


        return maxKnapsack;
    }


    public static void main(String[] args){

    }
}
