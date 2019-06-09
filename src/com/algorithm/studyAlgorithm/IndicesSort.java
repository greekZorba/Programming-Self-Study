package com.algorithm.studyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 정해진 범위가 있다면 Counting Sort, Radix Sort가 가장 빠르다
 * time complexity : O(n)
 * Indeces sort : 인덱스를 정렬함
 *
 * 아래 문제는 입력값이 99까지만 들어온다고 가정했을 때이다.
 * 인덱스를 정렬할 때는 정렬하려는 숫자 배열과 인덱스를 따로 저장해서
 * 정렬할 때 숫자배열이 들어갈 자리에 인덱스를 넣어주면 된다. 
 * */
public class IndicesSort {

    public void solution(List<Integer> unsortedList, int range) {
        int[] countingArray = new int[range+1];
        List<Integer> sortedArray = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();


        for(int i= 0; i<unsortedList.size(); i++) {
            countingArray[unsortedList.get(i)]++;
            sortedArray.add(unsortedList.get(i));
            indexList.add(i);
        }

        for(int i=1; i<countingArray.length; i++){ // 숫자들의 누적합
            /** 누적합은 숫자들이 어디로 들어갈 지 인덱스를 알려준다 */
            countingArray[i] = countingArray[i]+countingArray[i-1];
        }

        for(int i=unsortedList.size()-1; i>=0; i--){

            /** -1을 해준 이유는 누적합이 숫자들이 들어갈 자리를 알려주지만
             *   배열은 0번부터 시작해서 -1로 인덱스를 맞춰줌
             *  누적합의 값은 인덱스가 1로 시작했을 경우로 나온 결과이다
             * */
            sortedArray.set(countingArray[unsortedList.get(i)]-1, unsortedList.get(i));
            indexList.set(countingArray[unsortedList.get(i)]-1, i);
            countingArray[unsortedList.get(i)]--;
        }

        for(int i=0; i<sortedArray.size(); i++) {
            System.out.println();
            System.out.print("index : " + indexList.get(i)+ " ");
            System.out.print("value : " + sortedArray.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(3);
        unsortedList.add(99);
        unsortedList.add(1);
        unsortedList.add(34);
        unsortedList.add(78);
        unsortedList.add(34);
        int range = 99;
        IndicesSort indicesSort = new IndicesSort();
        indicesSort.solution(unsortedList, range);
    }
}
