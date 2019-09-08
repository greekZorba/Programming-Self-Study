package com.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {

    public void studySort() {
        Stream<Integer> sortedNum = Arrays.asList(4,6,1,3,8,10,2,24,446,11)
                .stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed());

        List<Integer> sortedNumList = sortedNum.collect(Collectors.toList());

        System.out.println(sortedNumList.toString());
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.studySort();
    }
}
