package com.java8.optional;

import java.util.Optional;

public class IsPresent {

    public void studyIsPresent() {
        Optional<String> optionalStr = Optional.ofNullable(sumPrefix("hi"));

        // value가 존재하는지 하지 않는지 체크해주는 메서드
        if(optionalStr.isPresent()){
            System.out.println("I've got result!!");
        }
        // null을 return 받으면 아래의 로직을 탄다.
        else {
            System.out.println("I've not got result!! ㅠㅠㅠㅠ");
        }
    }

    public String sumPrefix(String paramStr) {
//        return "!!"+paramStr;

        return null;
    }

    public static void main(String[] args) {
        IsPresent isPresent = new IsPresent();
        isPresent.studyIsPresent();
    }
}
