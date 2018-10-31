package com.concept;

/**
 * 배타적 논리합에 관해서
 *
 * 설명: 수리 논리학에서 주어진 2개으 ㅣ명제 가운데 1개만 참일 경우를 판단하는 논리 연산이다.
 *
 * 명제 P | 명제 Q |  P XOR Q
 *    1   |    1   |    0
 *    1   |    0   |    1
 *    0   |    1   |    1
 *    0   |    0   |    0
 *
 * */
public class XorStudy {

    public static void main(String[] args){

        int firstP = 1;
        int firstQ = 1;
        System.out.print("명제 P가 1이고, 명제 Q가 1일 때 배타적 논리합의 결과 : ");
        System.out.print(firstP^firstQ);
        System.out.println();

        int secondP = 1;
        int secondQ = 0;
        System.out.print("명제 P가 1이고, 명제 Q가 0일 때 배타적 논리합의 결과 : ");
        System.out.print(secondP^secondQ);
        System.out.println();

        int thirdP = 0;
        int thirdQ = 1;
        System.out.print("명제 P가 0이고, 명제 Q가 1일 때 배타적 논리합의 결과 : ");
        System.out.print(thirdP^thirdQ);
        System.out.println();

        int forthP = 0;
        int forthQ = 0;
        System.out.print("명제 P가 0이고, 명제 Q가 0일 때 배타적 논리합의 결과 : ");
        System.out.print(forthP^forthQ);
        System.out.println();




    }

}
