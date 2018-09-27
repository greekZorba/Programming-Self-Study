package com.algorithm.dataStructure;

/********************************************************************
 *
 *
 * n queens problem(체스에서 퀸을 놓았을 때 겹치지 않게 모두 놓을 수 있게 함)
 * 을 활용한 백트래킹 정리
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class BackTracking {

    static int[] backTrackingRoute;
    static int N; // 체스판의 크기
    public static void main(String[] args){
        N = 8; // 체스판의 크기
        backTrackingRoute = new int[N+1];
        queens(0);
        for(int i=1; i<backTrackingRoute.length; i++){
            System.out.print("행: "+i + " 열: "+backTrackingRoute[i]);
            System.out.println();
        }

    }

    private static boolean queens(int level){

        if(!promising(level)){ // 같은 열에 놓였거나, 대각선으로 놓인 것을 검증
            return false;
        }else if(level == N){ // 행의 수가 체스판 크기와 같아졌다는 건 겹치지 않게 루트를 찾았다는 의미라서 끝
            return true;
        }else{ // 자식들을 재귀로 방문함(다음 단계로 나아감)

            for(int i=1; i<=N; i++){
                backTrackingRoute[level+1] = i; // 열마다 하나씩 놓아보면서 테스트함
                if(queens(level+1)){ // 모든 경로를 탐색해서 마지막까지 겹치는 것 없이 놓여졌을 때 true 반환
                    return true;
                }
            }

            return  false; // 어디에도 겹치지 않게 놓을 자리가 없음
        }

    }

    private static boolean promising(int level){

        for(int i=1; i<level; i++){
            if(backTrackingRoute[i] == backTrackingRoute[level]){ // 같은 열에 놓였을 때
                return false;
            }else if(level-i == Math.abs(backTrackingRoute[level]-backTrackingRoute[i])){ // 대각선으로 놓였을 때
                return false;
            }
        }
        return true;
    }
}
