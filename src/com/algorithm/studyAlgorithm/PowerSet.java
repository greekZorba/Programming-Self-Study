package com.algorithm.studyAlgorithm;

/********************************************************************
 *
 *
 * PoserSet(멱집합)
 * 해당하는 집합의 모든 부분집합
 *
 * 상태공간트리: 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 후보키
 *            트리의 모든 노드를 방문하면 해를 찾을 수 있다.
 *            루트에서 출발하여 체계적으로 모든 노드를 방문하는 절차를 기술한다.
 *
 * 리프노드: 자식이 없는 노드
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/

public class PowerSet {

    private static String[] powerSetArray;
    private static int powerSetLength;
    private static boolean[] include; // 트리 상에서 현재 내 위치를 알려줌
    private static StringBuilder sb;

    public static void main(String[] args){
        sb = new StringBuilder();
        sb.append("{");
        powerSetArray = new String[]{"a","b","c","d"};
        powerSetLength = powerSetArray.length;
        include = new boolean[powerSetLength];

        powerSet(0); // 트리의 시작 높이인 0부터 시작해준다

        sb.setLength(sb.length()-2);
        System.out.println(sb.toString());
    }

    private static void powerSet(int level){ // 트리 상에서 현재 내 위치를 알려줌

        if(level == powerSetLength){ // 내 위치가 리프노드라면! (노드의 마지막 끝)
            sb.append("{");
            for(int i=0; i<powerSetLength; i++){

                if(include[i]){
                    sb.append(powerSetArray[i]+" ");
                }
            }
            sb.setLength(sb.length()-1);
            sb.append("}, ");

            return;
        }

        include[level] = false; // 트리 왼쪽 먼저 조회 - 자신이 포함 안 된 집합
        powerSet(level+1);

        include[level] = true; // 트리 오른쪽 조회 - 자신이 포함된 집합
        powerSet(level+1);

    }
}
