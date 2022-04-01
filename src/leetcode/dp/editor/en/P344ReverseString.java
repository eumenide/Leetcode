//Write a function that reverses a string. The input string is given as an 
//array of characters s. 
//
// You must do this by modifying the input array in-place with O(1) extra 
//memory. 
//
// 
// Example 1: 
// Input: s = ['h','e','l','l','o']
//Output: ['o','l','l','e','h']
// Example 2: 
// Input: s = ['H','a','n','n','a','h']
//Output: ['h','a','n','n','a','H']
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
// Related Topics Two Pointers String Recursion 👍 4603 👎 926


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-01 23:06:47
 * @title: Reverse String
 */
public class P344ReverseString {
    
    public static void main(String[] args) {
        Solution_344 solution = new Solution_344();
        // TO TEST
        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s);

        s = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s);
        System.out.println(s);
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_344 {
    public void reverseString(char[] s) {
        // 双指针
        int left = 0, right = s.length - 1;
        while (left < right) {
            char ch = s[left];
            s[left++] = s[right];
            s[right--] = ch;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
