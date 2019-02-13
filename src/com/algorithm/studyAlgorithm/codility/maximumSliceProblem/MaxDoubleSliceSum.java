package com.algorithm.studyAlgorithm.codility.maximumSliceProblem;

public class MaxDoubleSliceSum {

    public int solution(int[] A) {

        /**
         * X,Y,Z에 해당하는 인덱스 사이에 있는 값들의 최대값을 구하는 문제이다.
         * 여기서 Y에 해당하는 인덱스를 중간 포인트로 생각하는 것이 키포인트다.
         * 왼쪽에서 시작하는 최대합을 구한다. - maxLeft  (golden slice algorithm)
         * 오른쪽에서 시작하는 최대합을 구한다. - maxRight
         *
         * 왼쪽 최대합과 오른쪽 최대합 중간에 Y 인덱스가 존재한다고 생각한다.
         * Y가 왼쪽과 오른쪽을 나눠주는 기준이 된다.
         *
         * 왼쪽 최대합과 오른쪽 최대합이 Y 인덱스를 기점으로 가장 큰 값을 가지면
         * maxDoubleSliceSum을 구할 수 있다.
         *
         * 참조: https://github.com/Mickey0521/Codility/blob/master/MaxDoubleSliceSum.java
         * */

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int maxDoubleSliceSum = 0;

        /**
         * 1부터 시작하는 이유는 제일 작은 인덱스 0을 선택하더라도 인덱스 0은 제외된다.
         * 예를 들어,
         * maxLeft[1]은 인덱스 0을 제외하고 최대합이 되는 것이다. 문제에서 설명하는 'X'가 0이라고 보면 된다.
         *
         * 그래서 X가 가질 수 있는 최대 인덱스는 Y,Z가 끝자리에 붙어있다고 고려하면 '배열의 길이 -2' 번째 인덱스까지다.
         * */
        for(int i=1; i<A.length-2; i++){
            maxLeft[i] = Math.max(0, maxLeft[i-1]+A[i]);
        }

        /**
         * 문제 속의 Z 인덱스라고 생각하면 된다.
         * '배열의 길이 -1'이 마지막 인덱스이므로 가장 마지막 인덱스를 선택하면 마지막 인덱스를 제외한 합부터
         * 실제 숫자를 더하게 되므로 '배열의 길이 -2'부터 시작한다.
         *
         * array = [1,2,3,9,-2] 배열이 있고 마지막 인덱스부터 시작하면 array[4]인 -2는 제외하고 9부터 더한다.
         * 여기서 4가 인덱스 'Z'로 볼 수 있다.
         * */
        for(int i=A.length-2; i>1; i--){
            maxRight[i] = Math.max(0, maxRight[i+1]+A[i]);
        }

        /**
         * 여기서 인덱스 i는 문제 속의 Y를 담당하며 중간 인덱스로 제외되는 부분을 담당한다.
         * */
        for(int i=1; i<A.length-1; i++){

            if(maxLeft[i-1]+maxRight[i+1] > maxDoubleSliceSum){
                maxDoubleSliceSum = maxLeft[i-1]+maxRight[i+1];
            }
        }

        return maxDoubleSliceSum;
    }

    public static void main(String[] args) {
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        int[] A = new int[]{-3,5,-4,-5,20,-1,5,-6,-7};
//        int[] A = new int[]{0,0,3};
        System.out.println(maxDoubleSliceSum.solution(A));
    }

}
