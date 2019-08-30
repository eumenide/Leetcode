package leetcode;

/**
 * @author eumes
 * @date 2018/7/24
 */
public class One_Four {

    public static void main(String[] args){
        String[] strings = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || 0 == strs.length) {
            return "";
        }
        String prefix = strs[0];
        for (String s:strs ) {
            if (prefix == s) {
                continue;
            }
            for(int i = 0; i < prefix.length(); ++i) {
                if (i == s.length() || s.charAt(i) != prefix.charAt(i)) {
                    prefix = prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
}
