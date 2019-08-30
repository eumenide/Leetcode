package leetcode;

/**
 * @author eumes
 * @date 2018/7/19
 */
public class Seven {
    public static void main(String[] args){

        System.out.println(reverse(-324));
    }

    public static int reverse(int x) {
        long result = 0l;

        while (x != 0) {
            int a = x % 10;
            x  /= 10;
//            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && a > 7))
//                return 0;
//            if(result < Integer.MIN_VALUE /10 || (result == Integer.MIN_VALUE / 10 && a < -8))
//                return 0;
            result = result * 10 + a;
        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        return (int)result;
    }
}
