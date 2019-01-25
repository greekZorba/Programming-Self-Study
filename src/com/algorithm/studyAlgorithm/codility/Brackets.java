package com.algorithm.studyAlgorithm.codility;

import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        int result = 0;
        Stack<Character> checkStack = new Stack<>();

        if(S.length() > 0){
            checkStack.push(S.charAt(0));
        }else{
            return 1;
        }

        for(int i=1; i<S.length(); i++){

            if(checkStack.empty() && (S.charAt(i) == ')' || S.charAt(i) == '}' || S.charAt(i) == ']')){
                return 0;
            }

            if(!checkStack.empty() && (checkStack.peek() == '(' && S.charAt(i) == ')'
                    || checkStack.peek() == '{' && S.charAt(i) == '}'
                    || checkStack.peek() == '[' && S.charAt(i) == ']')){
                checkStack.pop();
            }else{
                checkStack.push(S.charAt(i));
            }

        }

        if(checkStack.empty()){
            result = 1;
        }

        return result;
    }


    public static void main(String[] args) {
        Brackets brackets = new Brackets();
//        String S = "{{(([]))}}{}[](({()}))";
        String S = "(";
        System.out.println(brackets.solution(S));
    }
}
