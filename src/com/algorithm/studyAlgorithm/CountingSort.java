package com.algorithm.studyAlgorithm;

/********************************************************************
 *
 *
 * CountingSort
 *
 * CountingSort는 RadixSort와 같이 다른 정렬법과 다르게 non-comparison-sort이다
 * 입력값에 정해진 범위가 있다는 전제 하에 정렬한다
 * 입력값을 index로 만들어서 같은 입력값이 나올 때마다 입력값을 index로 하는 배열을 +1씩 한다
 * 구해진 counting 배열을 누적으로 더해주면 가장 앞에 나오는 숫자부터 누적으로 더해지는데
 * 이는 정렬을 하는데 어느자리로 들어갈 지 알려준다
 *
 * CountingSort는 StableSort이기 때문에 입력순서와 출력순서는 같아야한다.
 * 초기 입력 배열을 거꾸러 읽어주면서 정렬을 하면 동일한 수라도 나중에 입력된 배열값이 나중에 출력된다
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class CountingSort {

    private static int[] inputArray;
    private static int[] countingArray;
    private static int[] sortedArray;
    public static void main(String[] args){
        int range = 9; // 숫자가 들어가는 범위: 0~5가 배열에 들어갈 수 있음
        inputArray = new int[]{2,5,3,0,2,3,0,3,7,9,1,4,6,7,3,5,8,2,4};
        System.out.print("최초 입력값으로 들어간 배열 : ");
        for(int before: inputArray){
            System.out.print(before + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------");

        countingSort(inputArray, range);

        System.out.print("countingSort가 된 배열 : ");
        for(int after: sortedArray){
            System.out.print(after + " ");
        }
        System.out.println();
    }

    private static void countingSort(int[] unsortedArray, int range){
        countingArray = new int[range+1];
        sortedArray = new int[unsortedArray.length];

        for(int i=0; i<unsortedArray.length; i++){ // 해당 숫자의 카운팅
            countingArray[unsortedArray[i]]++;
        }

        for(int i=1; i<countingArray.length; i++){ // 숫자들의 누적합

            /** 누적합은 숫자들이 어디로 들어갈 지 인덱스를 알려준다 */
            countingArray[i] = countingArray[i]+countingArray[i-1];
        }

        /** 주어진 초기 배열을 뒤에서 읽으면서 누적합을 보고 들어갈 자리를 찾아 넣어줌
         *  그럼 정렬이 된다!
         * */
        for(int i=unsortedArray.length-1; i>=0; i--){

            /** -1을 해준 이유는 누적합이 숫자들이 들어갈 자리를 알려주지만
            *   배열은 0번부터 시작해서 -1로 인덱스를 맞춰줌
             *  누적합의 값은 인덱스가 1로 시작했을 경우로 나온 결과이다
            * */
            sortedArray[countingArray[unsortedArray[i]]-1] = unsortedArray[i];

            countingArray[unsortedArray[i]]--;
        }

    }
}
