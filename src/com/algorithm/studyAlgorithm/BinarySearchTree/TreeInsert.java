package com.algorithm.studyAlgorithm.BinarySearchTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class TreeInsert {

    private static LinkedList<Integer> binaryTree;
    private static String result;
    public static void main(String[] args){
        binaryTree = new LinkedList<>();
        binaryTree.add(8); binaryTree.add(5); binaryTree.add(7);
        binaryTree.add(2); binaryTree.add(10); binaryTree.add(3);
        binaryTree.add(40); binaryTree.add(6); binaryTree.add(20);
        binaryTree.add(55); binaryTree.add(21); binaryTree.add(33);
        Collections.sort(binaryTree); /** 이진검색트리로 만들어줌 */
        System.out.print("이진검색트리 배열 :");
        for(int out: binaryTree){
            System.out.print(out+" ");
        }
        System.out.println();
        System.out.println("트리를 타고 가는 과정 --");

        insertIntoBinarySearchTree(binaryTree, 18);
    }

    private static void insertIntoBinarySearchTree(LinkedList<Integer> inputArray, int insertValue){
        int preParentNode = -1;
        int forwardNode = inputArray.size()/2;
        int startIndex = 0;
        int endIndex = inputArray.size();

        while(forwardNode > startIndex){
            preParentNode = forwardNode;

            if(insertValue > inputArray.get(forwardNode)){

                startIndex = forwardNode;
                forwardNode = (startIndex+endIndex)/2;
            }else{

                endIndex=forwardNode;
                forwardNode = (startIndex+endIndex)/2;
            }

        }
        System.out.println(preParentNode);
        inputArray.add(preParentNode, insertValue);
        System.out.println(inputArray.toString());
    }


}
