package newcoder;

import java.util.*;

/**
 * @author: eumes
 * @date: 2019/12/8
 **/
public class Main {

    public static void main(String[] args) {
//        Solution_4();
//        Solution_6();
//        Solution_1();
        Solution_2();
    }

    public static void Solution_1() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println(k * 3 + 1);
    }

    public static void Solution_2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arrs = new int[n + 1][n + 1];

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arrs[a][b] = 1;
        }

        boolean[] flag = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        int size = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        List<String> list1 = new ArrayList<>();

        while (!stack.empty()) {
            int now = stack.pop();
            flag[now] = true;
            list.add(now);
            int num = 0;
            for (int i = 0; i < n + 1; i++) {
                if (arrs[i][now] == 1 && !flag[i]) {
                    stack.push(i);
                    num++;
                }
                if (arrs[now][i] == 1 && !flag[i]) {
                    stack.push(i);
                    num++;
                }
            }

            if (num == 0) {
                if (list.size() >= size) {
                    list1.add(list.toString());
                }
            }
        }

        System.out.println(list.toString());
        System.out.println(list1.toString());

    }

    public static void Solution_3() {

    }

    public static void Solution_4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int[] arrs = new int[n];
        boolean[] flag = new boolean[n];
        long[] res = new long[n];
        long now = Long.MAX_VALUE;
        int nowIdx = -1;

        for (int i = 0; i < n; i++) {
            arrs[i] = scanner.nextInt();
            flag[i] = false;
            if (arrs[i] < now) {
                now = arrs[i];
                nowIdx = i;
            }
        }

        now += p;
        res[nowIdx] = now;
        flag[nowIdx] = true;
        int minIdx;
        int minV;

        for (int i = 1; i < n; i++) {
            minIdx = -1;
            minV = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!flag[j]) {
                    if (arrs[j] <= now) {
                        now += p;
                        res[j] = now;
                        flag[j] = true;
                        break;
                    } else if (arrs[j] < minV){
                        minIdx = j;
                        minV = arrs[j];
                    }
                }

                if (j == n - 1){
                    now = minV + p;
                    res[minIdx] = now;
                    flag[minIdx] = true;
                }
            }
        }

        System.out.print(res[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + res[i]);
        }


    }

    public static void Solution_6() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        int[] prods = new int[T];
        long[][] matrix = new long[T][n];

        for (int i = 0; i < T; i++) {
            prods[i] = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextLong();
            }
        }

        List<String> list = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n && k != j; k++) {
                    if (matrix[i][j] - matrix[i][k] == prods[i]) {
                        tmp.add(j + "," + k);
                    }
                }
            }
            if (i == 0) {
                list.addAll(tmp);
            } else {
                for (String string:
                     list) {
                    if (!tmp.contains(string)) {
                        list.remove(string);
                    }
                }
            }
            tmp.clear();
        }

        System.out.println(list.size());

    }

    private static class Person {
        int idx;
        int time;
    }
}
