package com.java8.optional;

import java.util.Optional;

public class OrElse {

    // null이 아닐 경우
//    private Optional<String> optionalStr = Optional.ofNullable(sumPrefix("hi"));

    // null일 경우
    private Optional<String> optionalStr = Optional.ofNullable(null);

    public void studyOrElse() {
        // orElse는 null이 아니면 원래의 값을 reteurn
        // null이면 매개변수를 return
        String resultStr = optionalStr.orElse("I've not got result!! ㅠㅠㅠㅠ");
        System.out.println(resultStr);
    }

    public void studyOrElseGet() {
        // orElseGet은 null이 아니면 본래의 value를 return
        // null이면 매개변수로 들어간 함수 실행해서 return (물론 같은 타입이어야함)
        String resultStr = optionalStr.orElseGet(() -> returnSomeStr());
        System.out.println(resultStr);
    }

    public void studyOrElseThrow() {
        // null일 경우 throw를 던진다
        optionalStr.orElseThrow(NullPointerException::new);
    }

    public String sumPrefix(String paramStr) {
        return "!!"+paramStr;
    }

    public String returnSomeStr() {
        return "anything";
    }

    public static void main(String[] args) {
        OrElse orElse = new OrElse();
        orElse.studyOrElse();
        orElse.studyOrElseGet();
        orElse.studyOrElseThrow();
    }
}
