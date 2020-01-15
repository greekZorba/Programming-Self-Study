package com.algorithm.studyAlgorithm.dataStructure.queue;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    class Node<T> {
        private Node<T> next;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node addNode = new Node(value);

        if(last != null) {
            last.next = addNode;
        }

        last = addNode;

        if(first == null) {
            first = last;
        }

        size++;
    }

    public T poll() {
        T firstData = first.value;
        Node next = first.next;

        first.value = null;
        first.next = null;

        first = next;

        if(next == null) {
            last = null;
        }

        size--;
        return firstData;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("모든 element가 있을 때 size : "+queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("모든 element가 poll 된 이후 size : "+queue.size());

    }
}
