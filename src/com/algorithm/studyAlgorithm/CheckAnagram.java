package com.algorithm.studyAlgorithm;

import com.sun.tools.javac.comp.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 두 input이 주어졌을 때, Anagram이 맞는지 체크하는 알고리즘 만들기
 * 해당 알고리즘은 대소문자를 구분한다.
 * */
public class CheckAnagram {

    public boolean isAnagram(String firstInput, String secondInput) {
        Map<Character, Integer> criteriaString = new HashMap<>();

        if(firstInput.length() != secondInput.length()) {
            return false;
        }

        for(int i=0; i<firstInput.length(); i++) {
            char tempChar = firstInput.charAt(i);
            if(criteriaString.containsKey(tempChar)) {
                criteriaString.put(tempChar, criteriaString.get(tempChar)+1);

            }else{
                criteriaString.put(tempChar, 1);
            }
        }

        for(int i=0; i<secondInput.length(); i++) {
            char tempChar = secondInput.charAt(i);

            if(criteriaString.containsKey(tempChar)) {

                if(criteriaString.get(tempChar) == 0){ return false; }

                criteriaString.put(tempChar, criteriaString.get(tempChar)-1);
            }else{
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        CheckAnagram checkAnagram = new CheckAnagram();
        String firstInput = "defacb";
        String secondInput = "abcdef";
        System.out.println("애나그램 결과는 ? "+ checkAnagram.isAnagram(firstInput, secondInput));
    }
}
