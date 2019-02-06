package com.algorithm.studyAlgorithm.codility.sorting;

import java.util.Arrays;

/**
 *
 * 교차하거나 원을 포함하는 디스크의 개수를 구해야 함.
 *  ㄴ 해당 위치에 도달하는 디스크들의 수
 *
 * 현재 i 기준으로 반지름을 구해서 lower, upper 배열에 담는다.
 * lower 배열 : i - A[i]
 * upper 배열: i + A[i]
 *
 * 각 배열을 정렬한다.
 *
 * upper 보다 작은 lower 들은 반드시 가장 작은 upper 보다 큰 반지름을 갖는다. = 접점
 *
 * 다음 upper 에서 겹치지 않게 현재 i 만큼 빼준다.
 *
 * 참조: https://jobjava00.github.io/algorithm/codility/lesson6/NumberOfDiscIntersections/
 * */
public class NumberOfDiscIntersections {

    public int solution(int[] A) {

        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersection = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            /** lower[j]가 upper[i]보다 작다면
             * lower[j]보다 작은 lower[0], lower[1] ... lower[j]도
             * upper[i]와 접점이 생긴다.
             *
             * */
            while (j < N && upper[i] >= lower[j]) {
                intersection += j;
                intersection -= i;
                j++;
            }
        }

        if (intersection > 10000000) return -1;

        return intersection;

    }

    public static void main(String[] args) {
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
        int[] A = new int[]{1,5,2,1,4,2147483647};
        System.out.println(numberOfDiscIntersections.solution(A));
    }
}
