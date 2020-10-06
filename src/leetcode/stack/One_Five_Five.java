package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/

import java.util.Stack;

/**
 * title: Min Stack
 * description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 **/
public class One_Five_Five {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}


class MinStack {

	private final Stack<Integer> stack;
	private final Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.empty()) {
			minStack.push(x);
		} else {
			if (x < minStack.peek()) {
				minStack.push(x);
			} else {
				minStack.push(minStack.peek());
			}
		}
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}