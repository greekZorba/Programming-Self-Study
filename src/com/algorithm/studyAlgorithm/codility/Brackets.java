package com.algorithm.studyAlgorithm.codility;

public class Brackets {
    private int smallBracket = 0;
    private int middleBracket = 0;
    private int bigBracket = 0;

    public int solution(String S) {

        for(int i=0; i<S.length(); i++){
            checkBracket(S.charAt(i));

            if(smallBracket < 0 || middleBracket < 0 || bigBracket < 0) {
                return 0;
            }
        }

        return 1;
    }

    private void checkBracket(char inputBracket){

        if(inputBracket == '('){
            smallBracket++;
        }
        else if(inputBracket == ')'){
            smallBracket--;
        }
        else if(inputBracket == '{'){
            middleBracket++;
        }
        else if(inputBracket == '}'){
            middleBracket--;
        }
        else if(inputBracket == '['){
            bigBracket++;
        }
        else if(inputBracket == ']'){
            bigBracket--;
        }

    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        String S = "([)()]";
        System.out.println(brackets.solution(S));
    }
}
