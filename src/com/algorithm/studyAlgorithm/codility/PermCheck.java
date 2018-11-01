package src.com.algorithm.studyAlgorithm.codility;

/**
 *
 * Counting Elements 문제
 *
 * */
public class PermCheck {

    public static void main(String[] args){
        int[] A = new int[]{4,1,3};
        System.out.println(solution(A));
    }

    private static int solution(int[] A){
        int[] existArray = new int[A.length+1];
        int permutation = 1;
        for(int i=0; i<A.length; i++){

            if(A[i] > A.length){
                return 0;
            }
            existArray[A[i]]++;
        }

        for(int i=1; i<existArray.length; i++){

            if(existArray[i] == 0){
                permutation = 0;
                break;
            }
        }

        return permutation;
    }
}
