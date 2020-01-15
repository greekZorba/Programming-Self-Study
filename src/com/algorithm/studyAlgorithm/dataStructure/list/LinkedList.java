package com.algorithm.studyAlgorithm.dataStructure.list;

public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T value;

        Node(T value) {
            this.value = value;
        }

    }

    public Node<T> node(int index) {

        if(index <= size) {
            Node<T> present = first;
            for(int i=0; i<index; i++) {
                present = present.next;
            }

            return present;

        } else {
            throw new IndexOutOfBoundsException("해당 인덱스가 size를 벗어남");
        }
    }

    public void add(T value) {
        Node addNode = new Node(value);

        if(last != null) {
            last.next = addNode;
            addNode.prev = last;
        }

        last = addNode;

        if(first == null) {
            first = last;
            first.prev = null;
        }

        size++;
    }

    public void add(int index, T value) {
        if(size <= index) {
            throw new IndexOutOfBoundsException("인덱스 초과");
        }
        Node addNode = new Node(value);
        Node<T> frontIndexNode = node(index-1);

        // frontIndexNode는 원하는 위치(index)보다 1칸 앞에 있는 node
        // originNode는 들어가려는 위치에 있는 기존의 node
        Node originNode = frontIndexNode.next;
        originNode.prev = addNode;
        addNode.prev = frontIndexNode;

        // 새로운 노드의 last이 기존 인덱스에 위치해있던 노드의 first가 된다
        // 새로운 노드의 first는 기존 인덱스 1칸 앞에 있는 node의 last이 된다
        addNode.next = originNode;
        frontIndexNode.next = addNode;
        size++;
    }

    public void removeFirst() {
        Node next = first.next;
        first.value = null;
        first.next = null;
        first = next;

        if(next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;
    }

    public void remove() {
        Node prev = last.prev;
        last.prev = null;
        last.value = null;

        last = prev;
        size--;
    }

    public int size() {
        return size;
    }



    public T get(int index) {

        return node(index).value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node node = first;
        for(int i=0; i<size-1; i++) {
            sb.append(node.value + ", ");
            node = node.next;
        }
        sb.append(node.value + " ]");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(2, 10);
        linkedList.remove();

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(4));
        System.out.println("linkedList size : "+linkedList.size());
        System.out.println(linkedList.toString());

    }
}
