package com.algorithm.studyAlgorithm.huffmanCoding;

public class Run implements Comparable<Run>{

    public Run left;
    public Run right;
    public byte symbol;
    public int runLen; // 문장 길이
    public int freq; // 빈도

    /** 트리의 노드로 사용하기 위해서 왼쪽 자식과 오른쪽 자식 노드 필드를 추가한다. */

    /** 노드에 부여된 codeword를 저장하기 위한 필드들을 다음과 같이 추가한다. */
    public String codeword; // 부여된 codeword를 32비트 정수로 저장
    public String codewordLen; // 부여된 codeword의 길이. 즉, codewordLen비트가 실제 codeword

    /** 비교의 기준은 freq이다. */
    @Override
    public int compareTo(Run o) {
        return 0;
    }
}
