package com.algorithm.studyAlgorithm.codility;

import java.util.Arrays;

public class Triangle {

    /**
     * 삼각형의 성질인 '두 변의 길이는 다른 한 변의 길이보다 길다'를 설명한다.
     * 근데 범위가 음수까지 있는데, 현실에서는 음수의 변이 있을 순 없지만 이 문제는 음수 또한 범위이다.
     *
     * 범위가 int의 최대치이므로 최대치의 int가 더해지면 int의 범위를 넘기 때문에 long으로 형변환한다.
     *
     * 오름차순으로 나열했기 때문에 가장 긴 변보다 다음으로 긴 변, 다음다음으로 긴 변을 더 했을 때 가장 긴 변의 길이만
     * 넘으면 된다.
     * 나머지 비교는 가장 긴 변이 있기 때문에 어떻게 더해도 다른 한 변보다는 길 것이기 때문이다.
     * */
    public int solution(int[] A) {
        if(A.length < 3){
            return 0;
        }

        Arrays.sort(A);

        int result = 0;
        for(int i=A.length-1; i>=2; i--){

            if(A[i] < (long)A[i-1] + (long)A[i-2]){
                result = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        int[] A = new int[]{2147483647,2147483646,2147483645};
        System.out.println(triangle.solution(A));
    }
}
