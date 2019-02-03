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

        for(int i=0; i<A.length; i++){

                int leaderCount = 0;
                for(int j=0; j<=i; j++){

                    if(leader == A[j]){
                        leaderCount++;
                    }
                }

                boolean firstCheckFlag = false;
                if(leaderCount > (i+1)/2){
                    firstCheckFlag = true;
                }

                leaderCount = 0;
                for(int j=i+1; j<A.length; j++){

                    if(leader == A[j]){
                        leaderCount++;
                    }
                }

                boolean secondCheckFlag = false;
                if(leaderCount > (A.length-(i+1))/2){
                    secondCheckFlag = true;
                }

                if(firstCheckFlag && secondCheckFlag){
                    result++;
                }
        }


        return result;
    }

    public static void main(String[] args) {
        EquiLeader equiLeader = new EquiLeader();
        int[] A = new int[]{4,3,4,4,4,4};
        System.out.println(equiLeader.solution(A));
    }
}
