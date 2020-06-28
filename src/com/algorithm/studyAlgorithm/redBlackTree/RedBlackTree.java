package com.algorithm.studyAlgorithm.redBlackTree;

/**
 * 이진검색트리의 일종
 * 균형 잡힌 트리: 높이가 O(logN)
 * search, insert, delete 연산을 최악의 경우에도 O(logN) 시간으로 지원
 *
 * 각 노드는 하나의 키(key), 왼쪽 자식(left), 오른쪽 자식(right), 그리고 부모노드(p)의 주소를 저장
 * 자식 노드가 존재하지 않을 경우, NIL 노드라고 부르는 특수한 노드가 있다고 가정
 * 따라서 모든 리프노드는 NIL노드
 * 루트의 부모도 NIL노드라고 가정
 * 노드들은 내부노드와 NIL노드로 분류
 *
 * 각 노드들은 red이거나 black이다.
 * root와 leaves(nullable함)는 black이다.
 * 만약 노드가 red이면 해당 node의 자식 node는 black이다.
 * 모든 노드에 대해서 그 노드로부터 자손인 리프노드에 이르는 모든 경로에는 동일한 개수의 black노드가 존재한다.
 *
 * 노드 x의 높이 h(x)는 자신으로부터 리프 노드까지의 가장 긴 경로에 포함된 에지의 개수이다.
 * 노드 x의 블랙-높이 bh(x)는 x로부터 리프노드까지의 경로상의 블랙노드의 개수이다. (노드x 자신은 불포함)
 *
 * 높이가 h인 노드의 블랙-높이 bh >= h/2이다. (조건 중 레드노드는 연속될 수 없기때문에)
 * 노드 x를 루트로하는 임의의 서브트리는 적어도 2^bh(x) - 1개의 내부노드를 포함한다.(수학적 귀납법)
 *  -> 2^bh(x)는 한 노드당 2개의 자식 노드를 가질 수 있어서 이고, -1은 자신은 포함하지 않기 때문
 * n개의 내부노드를 가지는 레드블랙트리의 높이는 2log(n+1) 이하이다.
 *  -> n >= 2^bh - 1 >= 2^h/2 - 1 이므로, 여기서 bh와 h는 각각 루트 노드의 블랙-높이와 높이
 *
 * Left and Right Rotation
 * 시간복잡도 : O(1)
 * 이진탐색트리 특성 유지
 * */
public class RedBlackTree {

    /**
     * y = right[x] != NIL 이라고 가정
     * 루트 노드의 부모도 NIL이라고 가정
     * */
    public void leftRotation() {

    }

}
