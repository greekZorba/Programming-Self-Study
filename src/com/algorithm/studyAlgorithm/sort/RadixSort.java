package com.algorithm.studyAlgorithm.sort;

/********************************************************************
 *
 *
 * RadixSort
 *
 * RadixSort는 CountingSort 같이 다른 정렬법과 다르게 non-comparison-sort이다
 * RadixSort는 각 자리수를 비교하면서 정렬하는 방식이다
 * 123, 344, 532가 있다면 1의 자리인 123의 3, 344의 4, 532의 2를 먼저 정렬해준다
 * -> 532, 123, 344
 * 다음 10의 자리를 정렬한다. 123의 2, 344의 4, 532의 3
 * -> 123, 532, 344
 * 다음 100의 자리를 정렬한다. 123의 1, 344의 3, 532의 5
 * -> 123, 344, 532
 * 정렬 끝
 *
 * CountingSort 설명:(
 * 입력값에 정해진 범위가 있다는 전제 하에 정렬한다
 * 입력값을 index로 만들어서 같은 입력값이 나올 때마다 입력값을 index로 하는 배열을 +1씩 한다
 * 구해진 counting 배열을 누적으로 더해주면 가장 앞에 나오는 숫자부터 누적으로 더해지는데
 * 이는 정렬을 하는데 어느자리로 들어갈 지 알려준다)
 *
 * RadixSort는 StableSort이기 때문에 입력순서와 출력순서는 같아야한다.
 * 초기 입력 배열을 거꾸러 읽어주면서 정렬을 하면 동일한 수라도 나중에 입력된 배열값이 나중에 출력된다
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/

public class RadixSort {

    private static int[] inputArray;
    private static int[] countingArray;
    private static int[] sortedArray;
    public static void main(String[] args){
        inputArray = new int[]{357, 255, 122, 865,124,275,845,987,324,7,10,1200,3200,9}; // 초기 입력값인 배열
        sortedArray = new int[inputArray.length]; // 정렬됐을 때의 배열
        int placeValue = 4; // 몇 자릿수인지 나타내는 변수

        System.out.print("RadixSort 전 배열 : ");
        for(int before: inputArray){
            System.out.print(before + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------");

        radixSort(inputArray, placeValue);

        System.out.println("RadixSort 후 배열 : ");
        for(int after: sortedArray){
            System.out.print(after + " ");
        }
    }

    private static void radixSort(int[] unsortedArray ,int placeValue){

        for(int i=1; i<=placeValue; i++){
            countingSort(unsortedArray, i);
        }

    }

    private static void countingSort(int[] unsortedArray, int placeValue){
        countingArray = new int[10];

        for(int i=0; i<unsortedArray.length; i++){ // 해당 숫자의 카운팅
            /**
             * (unsortedArray[i]/(int)Math.pow(10, placeValue-1))%10를 한 이유는
             * 각 자릿수를 하나씩 비교하기 위해서이다. radix sort이다
             * 예를 들어 987이 주어지면 100으로 나누면 몫이 9, %10을 사용하면 9를 구할 수 있다
             * 987 중 8을 구하려면 10으로 나누면 몫이 98, %10을 사용하면 8을 구할 수 있다
             * 987 중 7을 구하려면 1로 나누면 몫이 987, %10을 사용하면 7을 구할 수 있다
             * */
            countingArray[(unsortedArray[i]/(int)Math.pow(10, placeValue-1))%10]++;
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
            sortedArray[countingArray[(unsortedArray[i]/(int)Math.pow(10, placeValue-1))%10]-1]
                    = unsortedArray[i];

            countingArray[(unsortedArray[i]/(int)Math.pow(10, placeValue-1))%10]--;
        }

        /** 자릿수마다 정렬된 순서를 다시 정렬되지 않는 배열에 넣어주면서 차례대로 정리해나간다*/
        for(int i=unsortedArray.length-1; i>=0; i--){
            unsortedArray[i] = sortedArray[i];
        }

    }
}
