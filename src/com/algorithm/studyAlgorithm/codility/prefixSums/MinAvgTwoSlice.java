package com.algorithm.studyAlgorithm.codility.prefixSums;

public class MinAvgTwoSlice {

    /**
     * 시간복잡도 O(N^2)
     *
     * 단순하게 일일이 비교해서 구하는 방법
     * */
    public int solution(int[] A){

        int minIndex = 0;
        double min = Double.MAX_VALUE;
        for(int i=0; i<A.length-1; i++){
            int sum = A[i];


            for(int j=i+1; j<A.length; j++){
                sum += A[j];
                double avg = sum/(j-i+1.0);

                if(min > avg){
                    min = avg;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    /**
     * 시간복잡도 O(N)
     * 원리: 평균을 구하기 위해서는 최소한 원소 2개 이상이 필요하다.
     *  조건 1. 2개 원소의 평균은 2개 원소 중 한 원소의 값보다 크다.
     *
     * 짝수.
     * 만약 원소가 짝수개라면 2개, 4개 등 짝수로 나눠서 평균을 구할 수 있다.
     * 4개의 부분집합은 2개의 부분집합으로 표현할 수 있다.(4개의 원소가 합친 원소의 평균은
     * 4개를 2개씩 나눈 원소들의 평균보다 클 수 밖에 없다. 조건1에 의해서)
     * ex)
     * 1, 5, 6, 10 에서 4개 원소의 평균은 (1+5+6+10)/4 = 5.5
     * 2개씩 묶으면 (1+5)/2 = 3, (6+10)/2 = 8 => 이들의 평균이 4개 원소 평균과 같다. (3+8)/2 = 5.5
     * 3과 8로 평균을 냈고 이들의 평균은 어느 한 원소보다 값이 클 수 밖에 없다.
     *
     * 홀수.
     * 2개의 부분집합으로 표현 안되는 홀수.
     * 만약 5개라면 3개, 2개로 나눌 수 있다.
     * 위에서 설명한 것처럼, 원소 5개의 평균은 원소 3개로 나눈 평균과 원소 2개로 나눈 평균 중 어느 하나보다는 값이 클 수 밖에 없다.
     * 3개의 원소 평균까지 구해서 비교하면 최소 평균을 구할 수 있다.
     * */
    public int solution2(int[] A){
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        for(int i =0; i<A.length; i++){
            double avg = 0;
            if(i <= A.length-2){
                avg = (A[i]+A[i+1])/2f;
                if(min > avg){
                    min = avg;
                    minIndex = i;
                }
            }

            if(i <= A.length-3){
                avg = (A[i]+A[i+1]+A[i+2])/3f;
                if(min > avg){
                    min = avg;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }


    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        int[] A = new int[]{4,2,2,5,1,5,8};
        System.out.println(minAvgTwoSlice.solution(A));

        System.out.println(minAvgTwoSlice.solution2(A));
    }
}
