import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users, int k) {
        if (users == null) {
            return "";
        }
        int maxB = 0;
        int maxIdx = 0;
        int len = users.length();
        for (int i = 0; i < len; ++i) {
            int tmp = 0;
            int j = i + 1;
            int l = (i + len - 1) % len;
            if (users.charAt(i) == 'b'){
                for (; j < len; ++j) {
                    if (users.charAt(j) == 'g') {
                        tmp++;
                    } else {
                        break;
                    }
                }
                for (; l >= 0; --l) {
                    if (users.charAt(l) == 'g') {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if (l == 0 && users.charAt(l) == 'g') {
                    for (int m = len - 1; m > j; --m) {
                        if (users.charAt(l) == 'g') {
                            tmp++;
                        } else {
                            break;
                        }
                    }
                }
                if (tmp > maxB) {
                    maxB = tmp;
                    maxIdx = i;
                }
            }
        }

        int maxT = 0;

        for (int i = 0; i < len; ++i) {
            int tmp = 1;
            int rest = k;
            if (users.charAt(i) == 'b') {
                for (int j = i + 1; j < len; ++j) {
                    if (users.charAt(j) == 'b') {
                        tmp++;
                    } else {
                        rest--;
                        if (rest < 0) {
                            break;
                        }
                    }
                }
                if (rest >= 0) {
                    for (int m = 0; m < i; ++m) {
                        if (users.charAt(m) == 'b') {
                            tmp++;
                        } else {
                            rest--;
                            if (rest < 0) {
                                break;
                            }
                        }
                    }
                }
                maxT = Math.max(maxT, tmp);
            }
        }

        return maxIdx + " " + maxT;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
        int k;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        k = in.nextInt();

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}