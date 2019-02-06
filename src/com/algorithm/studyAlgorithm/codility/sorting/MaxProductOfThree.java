package com.algorithm.studyAlgorithm.codility.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProductOfThree {

    /**
     * 시간복잡도 O(N*log(N))
     *
     * 인덱스를 오름차순에 맞춰 정렬
     * 단순하게 생각하면 오름차순으로 하고 맨 뒤에서 3개만 곱하면 제일 큰 수 같지만,
     * [-5,2,3,-5,6] 로 올 경우, -5 * -5 * 6 이 가장 크다.
     *
     * 음수인 원소 2개가 곱해지면 양수가 되고(-5 * -5), 그 절대값이 오름차순의 다른 값들보다 클 수 있다.
     * 하지만 음수인 원소 3개가 되면(-5 * -5 * -8) 음수가 되므로 음수는 2개의 원소 값만 곱할 수 있다.
     *
     * 그래서 아래와 같은 계산식을 통해 비교해서 가장 큰 값을 반환한다.
     * */
    public int solution(int[] A){
        Integer[] index = new Integer[A.length];
        for(int i=0; i<A.length; i++){
            index[i] = i;
        }

        /**
         * 인덱스만 값의 크기에 따라 변함
         * */
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(A[o1], A[o2]);
            }
        });

        int endLocation = index.length-1;
        int endMultiplication = A[index[endLocation]] * A[index[endLocation-1]] * A[index[endLocation-2]];
        int startMultiplication = A[index[0]] * A[index[1]] * A[index[endLocation]];

        return Math.max(endMultiplication, startMultiplication);
    }


    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
//        int[] A = new int[]{-3, 1, 2, -2, 5, 6};
        int[] A = new int[]{-5,2,3,-5,6};
        System.out.println(maxProductOfThree.solution(A));
    }
}
