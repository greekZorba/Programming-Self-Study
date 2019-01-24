package com.algorithm.studyAlgorithm.codility;

import java.util.EmptyStackException;
import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        int result = 0;
        Stack<Character> checkStack = new Stack<>();

        if(S.length() >=2){
            checkStack.push(S.charAt(0));
        }else{
            return result;
        }

        try{
            for(int i=1; i<S.length(); i++){

                if(checkStack.peek() == '(' && S.charAt(i) == ')'
                        || checkStack.peek() == '{' && S.charAt(i) == '}'
                        || checkStack.peek() == '[' && S.charAt(i) == ']'){
                    checkStack.pop();
                }else{
                    checkStack.push(S.charAt(i));
                }

            }

            if(checkStack.empty()){
                result = 1;
            }else{
                result = 0;
            }

        }catch (EmptyStackException e){
            result = 0;
        }

        return result;
    }


    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        String S = "{[()()]}";
        System.out.println(brackets.solution(S));
    }
}
