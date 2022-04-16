import java.util.*;

/**
 * 测试文件
 *
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2021-07-20
 * @copyright Copyright (c) www.alisports.com
 */
public class Test {

    public static void main(String[] args) {
        // testSort();
        System.out.println(findAnagrams("cbaebabacd", "abc"));

    }

    private static List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        // 窗口大小为p的长度
        int left = 0, right = 0, count = p.length();
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a']-- > 0) {
                // 表示right满足了p的一个元素
                count--;
            }
            // 右指针右移
            right++;
            // 表示，此时窗口刚好满足p
            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length()) {
                // 大于=0，表示在p中存在，否则在右指针访问时，会变成负数
                if (freq[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                // 窗口比p长1，左指针左移
                left++;
            }
        }

        Set<Integer> set = new HashSet<>();

        return list;
    }

    private static void testSort() {
        //sort(1, 1, 1, 1, 1, 2, 1, 1, 1);
        //sort(3, 2, 3, 2, 1, 31);
        //sort(2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

        // exception
        sort(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2);
    }

    private static void sort(Integer... ints) {
        List<Integer> list = Arrays.asList(ints);
        System.out.println(list.size());
        list.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(list);
    }
}
