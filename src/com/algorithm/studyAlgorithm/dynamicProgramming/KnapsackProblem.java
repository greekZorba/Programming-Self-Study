package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * knapsack problem
 * 가방 안에 최대한 높은 값을 한정된 양만큼 넣는 방법이다.
 *
 * 예를 들어, 강도가 들었을 때 그가 가진 가방에 들어가는 양만큼
 * 최대한 비싼 물건을 담아야한다.
 *
 * 배낭의 용량은 초과하지 않으면서 최대가 되는 부분 집합
 *
 * i는 순서, Vi는 가격,가치 Wi는 무게를 의미함.
 *
 * i | Vi | Wi
 * -----------
 * 1 | 1  | 1
 * 2 | 6  | 2
 * 3 | 18 | 5
 * 4 | 22 | 6
 * 5 | 28 | 7
 *
 * OPT(i, w): 배낭 용량이 w일 때 아이템 1,2,...,i로 얻는 최대 이득
 * 경우 1 : 아이템 i를 선택하지 않는 경우
 *         OPT(i, w) = OPT(i-1, w)
 *
 * 경우 2 : 아이템 i를 선택하는 경우(넣을 수 있는 잔여무게보다 넣으려는 아이템의 무게가 더 크면 넣을 수 없다)
 *         OPT(i) = OPT(i-1, w-wi) + Vi
 *
 * 순환식
 *           -> 0               if i=0
 * OPT(i, w) -> OPT(i-1, w)     if Wi > W (잔여무게보다 넣으려는 아이템의 무게가 클 )
 *           -> max(OPT(i-1, w), OPT(i-1, w-Wi)+Vi ) Otherwise
 *
 *
 * */
public class KnapsackProblem {
    /**
     * 시간복잡도는 O(nW) 여기서 W는 입력의 갯수가 아닌 값임임
    * */

    public int[][] knapsack(int index, int permissibleWeight, int[] valueArray, int[] weightArray){

        // permissibleWeight는 최대 허용 무게
        int[][] maxKnapsack = new int[index+1][permissibleWeight+1];

        // index 순서가 된다. i-1은 i순서 아이템을 선택하기 이전이다.
        for(int i=1; i<=index; i++){

            // w는 동적으로 값이 올라가면서 허용 무게 점차 올라가면서 최대 허용 무게까지 올라갔을 때까지 비교를 한다.
            for(int w=1; w<=permissibleWeight; w++){

                if(weightArray[i] > w){
                    maxKnapsack[i][w] = maxKnapsack[i-1][w];
                }else{
                    maxKnapsack[i][w] = Math.max(maxKnapsack[i-1][w],
                            maxKnapsack[i-1][w-weightArray[i]]+valueArray[i]);
                }

            }
        }

        return maxKnapsack;
    }


    public static void main(String[] args){
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        int index = 5;
        int permissibleWeight = 11;
        int[] valueArray = new int[]{0,1,6,18,22,28};
        int[] weightArray = new int[]{0,1,2,5,6,7};

        int[][] result = knapsackProblem.knapsack(index, permissibleWeight, valueArray, weightArray);
        for(int i=0; i<result.length; i++){
            System.out.println();
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]+ " ");
            }
        }

        System.out.println();
        System.out.println("허용량만큼 최대 가치를 넣었을 경우 얻을 수 있는 가치 : "+result[index][permissibleWeight]);

    }
}
