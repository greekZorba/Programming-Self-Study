package com.algorithm.studyAlgorithm.codility;

import java.util.*;

public class Fish {

    public int solution(int[] A, int[] B) {
        int aliveCount = 0;
        Stack<Integer> downFishes = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) {    // up fish
                aliveCount++;

                if (downFishes.isEmpty()) {
                    continue;
                }

                int downFish = downFishes.peek();

                while (true) {
                    aliveCount--;

                    if (A[downFish] < A[i]) {
                        downFishes.pop();

                        if (downFishes.isEmpty()) {
                            break;
                        }

                        downFish = downFishes.peek();
                    }
                    else {
                        break;
                    }
                }
            }
            else {    // down fish
                downFishes.add(i);
                aliveCount++;
            }
        }

        return aliveCount;

    }

    public static void main(String[] args) {
        Fish fish = new Fish();
        int[] A = new int[]{4,3,2,1,5};
        int[] B = new int[]{0,1,0,0,0};
        System.out.println(fish.solution(A, B));
    }
}
