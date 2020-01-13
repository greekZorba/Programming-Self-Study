package com.algorithm.studyAlgorithm;

/********************************************************************
 *
 *
 * 정렬된 배열을 합치면서 재배열하는 소트 방식
 * 최소한의 크기까지 정렬을 나눈 다음(크기가 1인 정렬은 정렬되었다고 볼 수 있다),
 * 다시 합쳐주면서 정렬
 * 시간복잡도 O(nlogN) - 반으로 쪼개진 배열이 합쳐지기 때문에 logN이고
 * 그 연산의 수가 n개만큼 병합하기 때문에 시간복잡도는 O(nlogN)이 된다.
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class MergeSort {

    private static char[] mergeSortArray;
    private static char[] tmp;
    public static void main(String[] args){
        mergeSortArray = new char[]{'a','e','d','b','h','c','f','g','i'};
        tmp = new char[mergeSortArray.length];
        mergeSort(mergeSortArray, 0, mergeSortArray.length-1);

        System.out.print("합병정렬로 정렬된 배열: ");
        for(char output: mergeSortArray){
            System.out.print(output+" ");
        }

    }

    private static void mergeSort(char[] inputArray, int startPoint, int endPoint){

        if(startPoint < endPoint){ // 이 경우가 아니라면 배열의 크기가 1이거나 0이다
            int half = (startPoint+endPoint)/2; // 중간 지점 계산
            System.out.println("call stack order startPoint: "+startPoint + " half : " + half + " endPoint : "+endPoint);
            mergeSort(inputArray, startPoint, half); // 배열의 중간 지점부터 시작점까지 최소 크기까지 나눔
            mergeSort(inputArray, half+1, endPoint); // 배열의 중간 지점 이후부터 마지막 점까지 최소 크기까지 나눔
            merge(inputArray, startPoint, half, endPoint);
        }
    }

    private static void merge(char[] inputArray, int startPoint, int half, int endPoint){ // 분리된 정렬된 배열을 합치는 메서드
        System.out.println("merge order startPoint: "+startPoint + " half : " + half + " endPoint : "+endPoint);
        int start = startPoint; // 동적으로 증가될 시작점
        int tmpOrder = startPoint; // 임시 배열의 인덱스
        int afterHalf = half+1;
        while(start <= half && afterHalf <= endPoint){

            if(inputArray[start] <= inputArray[afterHalf]){
                tmp[tmpOrder++] = inputArray[start++];
            }else{
                tmp[tmpOrder++] = inputArray[afterHalf++];
            }
        }

        while(start <= half){
            tmp[tmpOrder++] = inputArray[start++];
        }
        while(afterHalf <= endPoint){
            tmp[tmpOrder++] = inputArray[afterHalf++];
        }


        for(int i=startPoint; i<=endPoint; i++){ // 진행하던 부분부터 채워넣기 때문에 start가 아닌 startPoint
            inputArray[i] = tmp[i];
        }
    }
}
