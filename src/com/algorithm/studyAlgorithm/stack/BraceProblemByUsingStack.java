package com.algorithm.studyAlgorithm.stack;

import java.util.Stack;
/**
 * stack을 이용해서 괄호 문제 풀기
 *
 * */
public class BraceProblemByUsingStack {

    static String[] braces(String[] values) {

        String[] output = new String[values.length];

        for(int i=0; i<values.length; i++) {
            Stack<Character> stack = new Stack<>();

            if(checkPair(stack, values[i])){
                output[i] = "YES";
            }else{
                output[i] = "NO";
            }

        }

        return output;

    }

    static boolean checkPair(Stack<Character> stack, String inputString){


        for(int j=0; j<inputString.length(); j++){

            switch (inputString.charAt(j)){
                case '(':
                case '[':
                case '{':
                    stack.push(inputString.charAt(j));
                    break;
                case ')':
                case ']':
                case '}':

                    if(stack.isEmpty()){
                        return false;
                    }else{
                        char peek = stack.pop();
                        if(!isPair(peek, inputString.charAt(j))){
                            return false;
                        }else{
                            break;
                        }
                    }

            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    static boolean isPair(Character top, Character closeBrace){

        if((top=='(') && (closeBrace != ')') ||
                (top=='[') && (closeBrace != ']') ||
                (top=='{') && (closeBrace != '}')){

            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] temp = new String[]{"{[}]"};
        String[] output = BraceProblemByUsingStack.braces(temp);
        for(String out : output) {
            System.out.println(out);
        }

    }
}
