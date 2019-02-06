package com.algorithm.studyAlgorithm.codility.stacksAndQueues;

import java.util.Stack;

public class Nesting {

    /** 괄호 스택 문제다!@ */
    public int solution(String S) {
        int result = 0;
        Stack<Character> openBrackets = new Stack<>();

        if(S.length() < 1){
            return 1;
        }else if(S.charAt(0) == ')'){
            return 0;
        }else{
            openBrackets.push(S.charAt(0));
        }

        for(int i=1; i<S.length(); i++){

            if(openBrackets.isEmpty() && S.charAt(i) == ')'){
                return result;
            }

            if(!openBrackets.isEmpty()
                    && openBrackets.peek() == '('
                    && S.charAt(i) == ')'){

                openBrackets.pop();
            }else{
                openBrackets.push(S.charAt(i));
            }

        }

        if(openBrackets.isEmpty()){
            result = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Nesting nesting = new Nesting();
        String S = "()()()";
        System.out.println(nesting.solution(S));
    }
}
