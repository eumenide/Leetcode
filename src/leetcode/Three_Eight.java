package leetcode;

/**
 * @author eumes
 * @date 2018/10/29
 *
 *  Count and Say
 *  Description:
 *      The count-and-say sequence is the sequence of integers with the first
 *      five terms as following:
 *      1.  1
 *      2.  11
 *      3.  21
 *      4.  1211
 *      5.  111221
 *      1 is read off as "one 1" or 11.
 *      11 is read off as "tow 1s" or 21.
 *      21 is read off as "one 2", then "one 1" or 1211
 *      Given an integer n where 1 <= n <= 30, generate the n-th term of the
 *      count-and-say sequence.
 *      Note: Each term of the sequence of integers will be represented as a string.
 *  Example:
 *      Input: 1
 *      Output: "1"
 *      Input: 4
 *      Output: "1211"
 */
public class Three_Eight {

    public static void main(String[] args){
        Three_Eight three_eight = new Three_Eight();

        int n = 3;

        System.out.println(three_eight.countAndSay(5));

    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = countAndSay(n - 1);
        String result = "";

        int count = 1;
        for (int i = 0; i < temp.length();) {
            if (i == temp.length() - 1) {
                result += "" + count + temp.charAt(i);
                break;
            }else if (temp.charAt(i) == temp.charAt(i + 1)) {
                count++;
                i++;
            }else {
                result += "" + count + temp.charAt(i++);
                count = 1;
            }
        }

        return result;
    }

}
