package com.algorithm.studyAlgorithm.codility.stacksAndQueues;

import java.util.*;

public class Fish {

    public int solution(int[] A, int[] B) {
        int surviveFishes = 0;
        Stack<Integer> downFlowingFishes = new Stack<>();

        for(int i=0; i<A.length; i++){

            /** 상류로 향하는 물고기 */
            if(B[i] == 0){

                /** 이미 다른 물고기랑 부딪힐 일 없는 물고기가 생존 */
                if(downFlowingFishes.isEmpty()){
                    surviveFishes++;
                    continue;
                }

                while(!downFlowingFishes.isEmpty()){
                    int approachFish = downFlowingFishes.peek();

                    /**하류로 내려가는 물고기가 상류로 올라오는 물고기보다 커서 잡아먹고
                     * 하류로 내려가는 물고기만 살아남은 물고기로 카운트 했으므로 카운트 해줄 필요 없음.
                     * */
                    if(A[approachFish] > A[i]){
                        break;
                    }
                    /** 상류로 가는 물고기가 하류로 내려오는 물고기를 잡아먹음 */
                    else if(A[approachFish] < A[i]){
                        downFlowingFishes.pop();
                        surviveFishes--;
                    }

                    /** 다른 물고기를 다 잡아먹은 물고기가 생존으로 한 마리 추가*/
                    if(downFlowingFishes.isEmpty()){
                        surviveFishes++;
                    }

                }
            }
            /** 하류로 향하는 물고기 */
            else if(B[i] == 1){
                downFlowingFishes.add(i);
                surviveFishes++;
            }

        }

        return surviveFishes;
    }

    public static void main(String[] args) {
        Fish fish = new Fish();
//        int[] A = new int[]{4,3,2,1,5};
//        int[] B = new int[]{0,1,0,0,0};

        int[] A = new int[]{4,3,6,2,1,7,5};
        int[] B = new int[]{0,1,1,0,0,0,0};
        System.out.println(fish.solution(A, B));
    }
}
