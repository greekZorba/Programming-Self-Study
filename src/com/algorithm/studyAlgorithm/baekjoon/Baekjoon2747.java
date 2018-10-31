package src.com.algorithm.studyAlgorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2747 {

    static long[] fibonacciArray;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fibonacciArray = new long[n+1];

        long fibonacci = getFibonacci(n);
        System.out.println(fibonacci);
    }

    private static long getFibonacci(int n){
        long fibonacciValue = 0;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        } else if(fibonacciArray[n] != 0){
            return fibonacciArray[n];
        } else{
            fibonacciValue = getFibonacci(n-1) + getFibonacci(n-2);
            fibonacciArray[n] = fibonacciValue;
            return fibonacciValue;
        }
    }

}
