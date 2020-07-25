package leetcode;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * title: Next Greater Element 1
 * description: You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class Four_Nine_Six {

	public static void main(String[] args) {
		int[] num1 = {4, 1, 2};
		int[] num2 = {1, 3, 4, 2};

		int[] res = nextGreaterElement2(num1, num2);

		System.out.println(Arrays.toString(res));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		boolean flag = false;

		for (int i = 0; i < nums1.length; i++) {
			for (int aNums2 : nums2) {
				if (flag && aNums2 > nums1[i]) {
					res[i] = aNums2;
					flag = false;
				} else if (nums1[i] == aNums2) {
					flag = true;
				}
			}
			if (flag) {
				res[i] = -1;
				flag = false;
			}
		}

		return res;
	}

	public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		for (Integer num : nums2){
			while (!stack.empty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}

		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.getOrDefault(nums1[i], -1);
		}

		return res;
	}

}
