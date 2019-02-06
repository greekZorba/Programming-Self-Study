package com.algorithm.studyAlgorithm.codility.leader;

import java.util.Stack;

/**
 *
 * 시간복잡도 : O(N*log(N)) or O(N)
 * */
public class Dominator {

    public int solution(int[] A) {
        final int NO_EXIST_LEADER = -1;
        int leader;
        int leaderIndex = 0;
        int leaderCount = 0;

        Stack<Integer> findLeader = new Stack<>();

        /** leader는 원소 중 가장 많은 수이므로 스택을 이용하면 leader를 찾을 수 있다. */
        for(int i=0; i<A.length; i++){

            if(!findLeader.isEmpty() && findLeader.peek() != A[i]){
                findLeader.pop();
            }else{
                findLeader.push(A[i]);
            }
        }


        if(findLeader.isEmpty()){

            return NO_EXIST_LEADER;
        }else{
            leader = findLeader.pop();
        }

        for(int i=0; i<A.length; i++){

            if(leader == A[i]){
                leaderCount++;
                leaderIndex = i;
            }
        }

        if(leaderCount > A.length/2){
            return leaderIndex;
        }else{
            return NO_EXIST_LEADER;
        }

    }

    public static void main(String[] args) {
        Dominator dominator = new Dominator();
        int[] A = new int[]{0, 0, 1, 1, 1};
        System.out.println(dominator.solution(A));
    }
}
