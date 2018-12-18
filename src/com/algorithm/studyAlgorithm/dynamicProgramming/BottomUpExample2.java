package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * 이항계수를 이용해 BottomUp을 구현하는 방법이다.
 * 이항계수란 주어진 크기의(순서 없는) 조합의 가짓수이다.
 *
 * nCk = (n) 즉, n개 중 k를 선택할 경우의 수이다.
 *       (k)
 *
 * (n) = { 1                if n=k or k=0
 * (k)   { (n-1) + (n-1)    otherwise
 *         ( k )   (k-1)    왜냐면 n에서 k를 제외하면 n-1 크기를 가진다. n-1에서 k를 선택할 경우와 안할 경우를 합하면
 *                          nCk의 경우의 수와 같다.
 *
 *  nCk를 구하는 공식: n!/(n-k)!k!
 * */
public class BottomUpExample2 {
}
