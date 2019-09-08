package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distinct {

    private List<String> companyList = Arrays.asList("kakao", "kakao", "kakao", "woowa");

    // stream의 distinct 메서드는 중복된 원소를 제거한다.
    public void studyDinstict() {
        Stream<String> distinctCompList =
                companyList.stream()
                        .distinct();
        List<String> collectionComp = distinctCompList.collect(Collectors.toList());
        System.out.println("distinct를 사용해서 중복된 원소 제거한 collection : "+collectionComp.toString());
    }

    public static void main(String[] args) {
        Distinct distinct = new Distinct();
        distinct.studyDinstict();
    }

}
