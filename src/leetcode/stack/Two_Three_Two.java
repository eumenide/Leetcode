package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * title: Implement Queue using Stacks
 * description: Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class Two_Three_Two {

	public static void main(String[] args) {

	}
}


class MyQueue {
	Stack<Integer> stack;
	Stack<Integer> stackTmp;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack = new Stack<>();
		stackTmp = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack.empty()) {
			stackTmp.push(stack.pop());
		}
		stack.push(x);
		while (!stackTmp.empty()) {
			stack.push(stackTmp.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.empty();
	}
}