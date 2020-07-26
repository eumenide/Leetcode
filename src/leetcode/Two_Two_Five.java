package leetcode;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * title: Implement Stack using Queues
 * description: Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 */
public class Two_Two_Five {

	public static void main(String[] args) {

	}
}

class MyStack {

	private final Queue<Integer> input;
	private final Queue<Integer> output;

	/** Initialize your data structure here. */
	public MyStack() {
		input = new ArrayDeque<>();
		output = new ArrayDeque<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		while (!input.isEmpty()) {
			output.offer(input.poll());
		}
		input.offer(x);
		while (!output.isEmpty()) {
			input.offer(output.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return input.poll();
	}

	/** Get the top element. */
	public int top() {
		return input.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return input.isEmpty();
	}
}
