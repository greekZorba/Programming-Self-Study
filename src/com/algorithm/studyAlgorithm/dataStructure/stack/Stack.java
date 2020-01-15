package com.algorithm.studyAlgorithm.dataStructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    int size = 0;
    List<Integer> stack;

    public void push(int input) {
        if(stack == null) {
            stack = new ArrayList<>();
        }
        size++;
        stack.add(input);
    }

    public int pop(){

        if(size <= 0) {
            throw new NullPointerException("stack이 비었음");
        }

        int peak = stack.get(size-1);
        stack.remove(size-1);
        size--;

        return peak;
    }

    public int peak() {
        return stack.get(size-1);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size);

    }


}
