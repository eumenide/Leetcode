package leetcode;

import java.util.HashMap;

/**
 * @author eumes
 * @date 2018/7/23
 */
public class One_Three {

    public static void main(String[] args){

        String s = "MCMXCIV";

        System.out.println(romanToInt1(s));
    }

    public static int romanToInt1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int i = 0;
        for(; i < s.length() - 1; ++i){
            int a = map.get(s.charAt(i));
            int b = map.get(s.charAt(i + 1));

            if (a < b) {
                result += b - a;
                i++;
            }else{
                result += a;
            }
        }
        if (i == s.length() - 1) {
            return result + map.get(s.charAt(i));
        }else {
            return result;
        }
    }
}
