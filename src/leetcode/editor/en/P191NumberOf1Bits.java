//Write a function that takes an unsigned integer and returns the number of '1' 
//bits it has (also known as the Hamming weight). 
//
// Note: 
//
// 
// Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, the input will be given as a signed integer type. It should not 
//affect your implementation, as the integer's internal binary representation is 
//the same, whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement 
//notation. Therefore, in Example 3, the input represents the signed integer. -3. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a 
//total of three '1' bits.
// 
//
// Example 2: 
//
// 
//Input: n = 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a 
//total of one '1' bit.
// 
//
// Example 3: 
//
// 
//Input: n = 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a 
//total of thirty one '1' bits.
// 
//
// 
// Constraints: 
//
// 
// The input must be a binary string of length 32. 
// 
//
// 
//Follow up: If this function is called many times, how would you optimize it? 
//Related Topics Bit Manipulation 👍 3433 👎 836


package leetcode.editor.en;

/**
 * Number of 1 Bits
 * 
 * @author: eumes
 * @date: 2022-05-26 23:14:00
 */
 public class P191NumberOf1Bits {
    public static void main(String[] args) {
        Solution_P191 solution = new Solution_P191();
        // TO TEST
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(128));
        System.out.println(solution.hammingWeight(-3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-3 >>> 1));
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // n & (n - 1)  可以消除最右边的1
        //  n - 1 会将n中最右边的 1 变成 0，并将这个1右边的所有0变成1
        //  之后在 & n，则这个1及之后的位置，全会变成0
        //  最终得到的结果，就是n中最右边的1变成了0
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
