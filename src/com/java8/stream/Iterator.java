package com.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iterator {

    private void streamIterator() {
        /**
         * iterate를 쓰면 무한대로 진행된다.
         * 아래에 seed(5)는 사용될 인자를 나타내고, 오른쪽의 n은 seed이고
         * 화살표 오른쪽은 해당 seed를 이용해 진행될 함수이다.
         *
         * Stream.iterate(seed, seed -> f(seed))와 같고,
         * iterate가 진행될수록 f(seed)의 결과값이 다음 함수의 seed가 된다.
         *
         * 첫번째가 .iterate(seed, seed -> f(seed))라면,
         * 두번째는 .iterate(f(seed), f(seed) -> f(f(seed)))이다.
         *
         * limit는 무한수열의 제한을 줄 수 있다.
         */

        Stream<Integer> hundredStream =
                Stream.iterate(5, n -> n+5)
                        .limit(10);
        System.out.println(hundredStream.collect(Collectors.toList()).toString());
    }

    public static void main(String[] args) {
        Iterator iterator = new Iterator();
        iterator.streamIterator();
    }
}
