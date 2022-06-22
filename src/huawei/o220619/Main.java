package huawei.o220619;

import java.util.*;

/**
 * @author: eumes
 * @date: 2022/6/19
 **/
public class Main {

	public static Set<Character> set = new HashSet<>();
	static {
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 输入
		int flaw = in.nextInt();
		in.nextLine();
		String str = in.nextLine();

		System.out.println(solve(flaw, str));
	}

	public static int solve(int flaw, String str) {
		// 0
		//asdbuisodeveasuufgh
		int maxLen = 0;
		int le = 0, ri = 0;
		int curFlaw = 0;
		while (ri < str.length()) {
			while (ri < str.length() && !set.contains(str.charAt(ri))) {
				// 如果右边不是元音，则右指针继续扩展
				ri++;
				curFlaw++;
			}
			if (ri == str.length()) {
				break;
			}
			// 此时ri是元音
			while (le < ri && !set.contains(str.charAt(le))) {
				// 如果左边不是元音，则左指针一直右移
				le++;
				curFlaw--;
			}
			if (le == str.length()) {
				break;
			}
			// 左右都是元音
			if (curFlaw == flaw) {
				// 满足条件取最大
				ri++;
				maxLen = Math.max(maxLen, ri - le);
			} else if (curFlaw < flaw) {
				// 缺陷度 < 目标，右指针扩展
				ri++;
			} else {
				// 缺陷度 > 目标，左指针右移
				le++;
			}
		}

		return maxLen;
	}

	public static void main_1(String[] args) {
		Scanner in = new Scanner(System.in);

		// 输入
		int aLen = in.nextInt();
		in.nextLine();
		String[] arrayA = new String[0];
		if (aLen > 0) {
			arrayA = in.nextLine().split(" ");
		}
		int bLen = in.nextInt();
		in.nextLine();
		String[] arrayB = new String[0];
		if (bLen > 0) {
			 arrayB = in.nextLine().split(" ");
		}

		Set<String> set = new TreeSet<>(Comparator.naturalOrder());
		for (String str : arrayA) {
			set.add(str);
		}
		for (String str : arrayB) {
			set.add(str);
		}

		System.out.println(set);
		System.out.println(set.toString().replaceAll(",", ""));
	}
}
