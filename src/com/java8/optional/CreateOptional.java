package com.java8.optional;

import java.util.Optional;

public class CreateOptional {

    public void studyOf() {
        // of()의 경우 null을 허용하지 않는다.
        // null이 들어오면 NPE 발생
        Optional<Integer> someInt = Optional.of(anyIntReturn());
    }

    public void studyOfNullable() {
        // ofNullable()의 경우 null을 허용한다.
        // null이 들어와도 NPE 발생하지 않음
        Optional<Integer> someInt = Optional.ofNullable(anyIntReturn());
    }

    public Integer anyIntReturn() {
//        return 1234;
        return null;
    }

    public static void main(String[] args) {
        CreateOptional createOptional = new CreateOptional();
        createOptional.studyOf();
        createOptional.studyOfNullable();
    }
}
