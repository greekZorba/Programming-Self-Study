package com.algorithm.studyAlgorithm.codility;

import java.util.Stack;

public class EquiLeader {

    public int solution(int[] A){
        Stack<Integer> leaderStack = new Stack<>();
        int leader = 0;
        int result = 0;

        for(int i=0; i<A.length; i++){

            if(!leaderStack.isEmpty() && leaderStack.peek() != A[i]){
                leaderStack.pop();
            }else{
                leaderStack.add(A[i]);
            }

        }

        if(!leaderStack.isEmpty()){
            leader = leaderStack.peek();
        }else{
            return leader;
        }

        int leaderTotalCount = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == leader){
                leaderTotalCount++;
            }
        }

        int frontLeaderCount = 0;
        for(int i=0; i<A.length; i++){

            if(A[i] == leader){
                frontLeaderCount++;
            }

            if(frontLeaderCount > (i+1)/2
                && leaderTotalCount-frontLeaderCount > (A.length-(i+1))/2){

                result++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        EquiLeader equiLeader = new EquiLeader();
        int[] A = new int[]{4,3,4,4,4,2};
        System.out.println(equiLeader.solution(A));
    }
}
