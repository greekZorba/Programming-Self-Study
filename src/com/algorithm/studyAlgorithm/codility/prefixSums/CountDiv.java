package com.algorithm.studyAlgorithm.codility.prefixSums;

public class CountDiv {

    /**
     * 시간복잡도 O(1)
     *
     * A <= i <= B 이므로
     * A쪽은 범위가 시작하는 수이기 때문에 K로 나누었을 때, 딱 맞아떨어지거나 몫의 +1을 해주어야 한다.
     * B쪽은 범위가 끝나는 수이기 때문에 K로 나누었을 때, 딱 맞아떨어지거나 나눈 몫만 체크한다.
     * 그래서 B쪽은 int로 사용하면 소수점 자리는 버려져서 따로 조건식을 세울 필요없다.
     *
     * A의 몫이 B의 몫을 넘어간다는 건 A와 B 사이에 K로 나누었을 때 나누어 떨어지는 알맞는 숫자가 없다는 의미이므로
     * 0을 반환한다.
     * */
    public int solution(int A, int B, int K){
        int quotientOfA;
        int quotientOfB = B/K;

        if(A%K == 0){
            quotientOfA = A/K;
        }else{
            quotientOfA = A/K+1;
        }

        if(quotientOfA > quotientOfB){
            return 0;
        }else{
            return  quotientOfB-quotientOfA+1;
        }



    }

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        int A = 1;
        int B = 1;
        int K = 11;
        System.out.println(countDiv.solution(A,B,K));


    }
}
