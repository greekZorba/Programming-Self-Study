package com.java8.optional;

import java.util.Optional;

public class IfPresent {

    public void studyIfPresent() {
        Optional<String> optionalStr = Optional.ofNullable(sumPrefix("hi"));

        // if문으로 value가 존재하는지 체크해주는걸 메서드로 만든 메서드
        // optionalStr에 값이 존재하면 ifPresent 안에 속한 로직이 발생
        optionalStr.ifPresent(s -> System.out.println("I've got result!! |||| and what is result ? " + s));
        optionalStr.orElse("I've not got result!! ㅠㅠㅠㅠ");
    }

    public String sumPrefix(String paramStr) {
        return "!!"+paramStr;
    }

    public static void main(String[] args) {
        IfPresent ifPresent = new IfPresent();
        ifPresent.studyIfPresent();
    }
}
