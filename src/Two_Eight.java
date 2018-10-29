/**
 * @author eumes
 * @date 2018/10/29
 *
 *  Implement strStr()
 *  Description:
 *      Return the index of the first occurrence of needle in haystack, or -1
 *      if needle is not part of haystack.
 *      For the purpose of this problem, we will return 0 when needle is an
 *      empty string. This is consistent to C's strstr() and Java's indexOf().
 *  Example:
 *      Input: haystack = "hello", needle = "ll"
 *      Output: 2
 *      Input: haystack = "aaaaa", needle = "bba"
 *      Output: -1
 */
public class Two_Eight {
    public static void main(String[] args){

        Two_Eight two_eight = new Two_Eight();

        String haystack = "hello";
        String needle = "bb";

        System.out.println(two_eight.strStr(haystack, needle));

    }

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int index = 0;
            while (index < needle.length() &&
                    needle.charAt(index) == haystack.charAt(index + i)){
                index++;
            }
            if (index == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
