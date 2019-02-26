package com.algorithm.studyAlgorithm.hash;

import java.util.LinkedList;

public class HashTable {

    public static class HashTableImpl{
        class Node{
            String key;
            String value;

            public Node(String key, String value){
                this.key = key;
                this.value = value;
            }

            String getValue(){
                return value;
            }
            void value(String value){
                this.value = value;
            }
        }

        LinkedList<Node>[] data;
        HashTableImpl(int size){
            this.data = new LinkedList[size];
        }

        // 아스키값을 구해서 모두 더한 값이 해쉬코드가 된다.
        int getHashCode(String key){
            int hashcode = 0;
            for(char c : key.toCharArray()){
                hashcode += c;
            }

            return hashcode;
        }

        // 해쉬코드를 링크드리스트의 인덱스 크기만큼 나눠준 값이 배열방의 인덱스가 된다.
        int converToIndex(int hashcode){
            return hashcode % data.length;
        }

        Node searchKey(LinkedList<Node> list, String key){
            if(list == null){ return null; }

            for(Node node : list){
                if(node.key.equals(key)){
                    return node;
                }
            }
            // 데이터를 못 찾았으면 null을 리턴
            return null;
        }

        void put(String key, String value){
            int hashcode = getHashCode(key);
            int index = converToIndex(hashcode);
            LinkedList<Node> list = data[index];
            if(list == null){
                list = new LinkedList<Node>();
                data[index] = list;
            }

            Node node = searchKey(list, key);
            if(node == null){
                list.addLast(new Node(key, value));
            }else{
                node.value(value);
            }
        }

        String get(String key){
            int hashcode = getHashCode(key);
            int index = converToIndex(hashcode);
            LinkedList<Node> list = data[index];
            Node node = searchKey(list, key);
            return node == null ? "Not found" : node.getValue();
        }

    }

    public static void main(String[] args) {
        HashTableImpl hashTable = new HashTableImpl(3);
        hashTable.put("game", "fifaOnline");
        hashTable.put("food", "chocolate");
        hashTable.put("car", "BMW");

        System.out.println("어떤 게임 ? "+hashTable.get("game"));
        System.out.println("어떤 음식 ? "+hashTable.get("food"));
        System.out.println("어떤 차 ? "+hashTable.get("car"));

        System.out.println("없는 데이터 찾아보기 ? "+hashTable.get("hello"));

        hashTable.put("food", "steak");
        System.out.println("데이터 엎어치기, 음식 위에 ? "+hashTable.get("food"));

    }
}
