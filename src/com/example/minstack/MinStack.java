package com.example.minstack;

import java.util.Stack;

/**
 * 实现最栈操作
 */
class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {

        int ele = dataStack.pop();
        if (minStack.peek() == ele) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */