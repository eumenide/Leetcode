package leetcode;

/**
 * @author eumes
 * @date 2018/7/19
 */
public class Nine {

    public static void main(String[] args){
        System.out.println(isPalindrome(1010));
    }

    public static boolean isPalindrome(int x){
        int y = 0;
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        while (y < x) {
            int a = x % 10;
            y = y * 10 + a;
            x /= 10;
        }
        return x == y || x == y / 10;
    }
}
