package com.algorithm.studyAlgorithm.codility;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        Stack<Integer> originHeight = new Stack<>();

        int blocks = 0;

        for(int i=0; i<H.length; i++){

            if(originHeight.isEmpty() || originHeight.peek() < H[i]){
                originHeight.push(H[i]);
                blocks++;

            }else if(originHeight.peek() == H[i]) {
                continue;

            }else{


                while(!originHeight.isEmpty()){

                    /** 기존 블록이 더 높으면 낮게 깔려있는 블록이 있는지 찾을때까지 pop. */
                    if(originHeight.peek() > H[i]){
                        originHeight.pop();

                    }

                    /** 기존의 높이보다 크거나 기존 블록 중 동일한 높이의 블록이 없을때 블록 추가 */
                    if(originHeight.isEmpty() || originHeight.peek() < H[i]){
                        originHeight.push(H[i]);
                        blocks++;
                        break;

                    }
                    /** 기존에 높이만큼의 벽이 있으면 블록 추가 필요없이 break; */
                    else if(originHeight.peek() == H[i]){
                        break;
                    }



                }
            }

        }

        return blocks;
    }

    public static void main(String[] args) {
        StoneWall stoneWall = new StoneWall();
        int[] H = new int[]{8,8,5,7,9,8,7,4,8};
        System.out.println(stoneWall.solution(H));
    }
}
