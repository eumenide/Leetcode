package leetcode.stack;

/**
 * title: Build an Array With Stack Operations
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: eumes
 * @date: 2020/7/24
 **/
public class One_Four_Four_One {

	public static void main(String[] args) {
		int[] target1 = {1, 3};
		int[] target2 = {1, 2, 3};
		int[] target3 = {1, 2};
		int[] target4 = {2, 3, 4};
		int n1 = 3;
		int n2 = 3;
		int n3 = 4;
		int n4 = 4;

		System.out.println(Arrays.toString(buildArray(target1, n1).toArray()));
		System.out.println(Arrays.toString(buildArray(target2, n2).toArray()));
		System.out.println(Arrays.toString(buildArray(target3, n3).toArray()));
		System.out.println(Arrays.toString(buildArray(target4, n4).toArray()));

	}

	public static List<String> buildArray(int[] target, int n) {
		List<String> list = new ArrayList<>();

		int idx = 1;
		for (int aTarget : target) {
			while (idx++ < aTarget) {
				list.add("Push");
				list.add("Pop");
			}
			list.add("Push");
		}

		return list;
	}
}
