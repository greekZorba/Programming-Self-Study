package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAndMapAndFlatMap {

    private List<String> companyList = Arrays.asList("google", "kakao", "naver", "woowa");

    public static void main(String[] args) {
        FilterAndMapAndFlatMap study = new FilterAndMapAndFlatMap();

        study.studyFilter();
        System.out.println();

        study.studyMap();
        System.out.println();

        study.studyFlatMap();
    }

    private void studyFilter() {
        // filter로 들어오는 매개변수는 companyList의 결과값으로 화살표 오른쪽으로 조건에 맞게 결과값을 걸러줌
        Stream<String> kakaoFilterStream =
                companyList
                        .stream()
                        .filter(s -> s.equals("kakao"));

        // stream -> list로 만들기
        List<String> makeList =
                kakaoFilterStream
                        .collect(Collectors.toList());

        System.out.println("kakao 이름이 일치하는 원소만 가져오기(filter 사용) : " + makeList.toString());
    }

    private void studyMap() {
        // map은 하나의 입력값에 대해 하나의 출력값을 생성한다. map 안에서 stream을 반환하면 아래와 같이
        // 이중으로 stream을 받아야한다.
        Stream<Stream<String>> result = companyList.stream().map(s -> splitChar(s));

        // .collect(Collectors.toList())는 stream을 collection 중의 하나인 list로 만들어준다.
        List<Stream> innerStream = result.collect(Collectors.toList());

        innerStream.forEach(s ->
            System.out.println("map 사용 시 여러개의 stream이 생김: "+s.collect(Collectors.toList()).toString())
        );
    }

    private void studyFlatMap() {
        // flatMap은 복수개의 stream이 발생하면 하나의 stream으로 합쳐준다.
        Stream<String> result = companyList.stream().flatMap(s -> splitChar(s));
        System.out.println("flatMap 사용 시 복수개로 발생한 stream을 하나로 합쳐준다 : "
                + result.collect(Collectors.toList()));
    }

    // 문자열을 하나의 문자로 쪼개서 stream으로 반환해주는 메서드
    private Stream<String> splitChar(String paramStr) {
        List<String> splitedStr = new ArrayList<>();

        for(char input : paramStr.toCharArray()) {
            splitedStr.add(String.valueOf(input));
        }

        return splitedStr.stream();
    }
}


