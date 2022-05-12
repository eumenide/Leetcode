//Given an integer n, return the number of strings of length n that consist 
//only of vowels (a, e, i, o, u) and are lexicographically sorted. 
//
// A string s is lexicographically sorted if for all valid i, s[i] is the same 
//as or comes before s[i+1] in the alphabet. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 5
//Explanation: The 5 sorted strings that consist of vowels only are ["a","e",
//"i","o","u"].
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 15
//Explanation: The 15 sorted strings that consist of vowels only are
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
//Note that "ea" is not a valid string since 'e' comes after 'a' in the 
//alphabet.
// 
//
// Example 3: 
//
// 
//Input: n = 33
//Output: 66045
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 50 
// 
// Related Topics Dynamic Programming 👍 2539 👎 58


package leetcode.editor.en;

/**
 * Count Sorted Vowel Strings
 * 
 * @author: eumes
 * @date: 2022-05-12 00:44:47
 */
 public class P1641CountSortedVowelStrings {
    public static void main(String[] args) {
//        Solution_P1641 solution = new Solution_P1641();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1641 {

    public int countVowelStrings(int n) {
        // 假设长度为i时，以a/e/i/o/u开头的数量分别为a[i]/e[i]/i[i]/o[i]/u[i]
        // 那么当长度为i+1时，以a开头的 = a[i]+e[i]+i[i]+o[i]+u[i]，以e开头的 = e[i]+i[i]+o[i]+u[i]
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int idx = 1; idx < n; idx++) {
//            a += e + i + o + u;
//            e += i + o + u;
//            i += o + u;
//            o += u;
            o += u;
            i += o;
            e += i;
            a += e;
        }

        return a + e + i + o + u;
    }

    public int countVowelStrings_bt(int n) {
        return backTrace(0, n, 0, 0);
    }

    private int backTrace(int start, int n, int count, int tmp) {
        if (tmp == n) {
            count++;
            return count;
        }

        for (int i = start; i < 5; i++) {
            tmp++;
            count = backTrace(i, n, count, tmp);
            tmp--;
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
