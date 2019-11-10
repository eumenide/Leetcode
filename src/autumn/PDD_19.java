package autumn;

import java.util.*;

/**
 * @author: eumes
 * @date: 2019/11/10
 **/
public class PDD_19 {
    public static void main(String[] args) {
//        Solution_1();
//        Solution_2();
        Solution_4();
    }

    public static void Solution_1() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long C = scanner.nextLong();

            long minNum = Math.min(A, B);

            long res = A + B - minNum - minNum;
            res = Math.max(C, res);

            minNum = Math.min(minNum, res);

            System.out.println(minNum);
        }

    }

    public static void Solution_2() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();

            int[] a = {0, 1, 1, 0};

            System.out.println(a[N % 4] + " " + (N - a[(N - 1) % 4]));
        }
    }

    public static void Solution_3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int num = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String a = arr[i] + ",";
            for (int j = i; j < n; j++) {

            }
        }

    }

    public static void Solution_4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[2 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            arr[i + n] = arr[i];
        }

        long max = 0;
        int num = 0;
        int rep = 0;
        int half = n / 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j - i <= half; j++) {
                int tmp = arr[i] + arr[j];
                if (j - i > half) {
                    tmp += (n - j);
                } else if (j - i == half) {
                    tmp += (j - i);
                    rep++;
                }else{
                    tmp += (j - i);
                }
                list.add(tmp);
                max = Math.max(max, tmp);
            }
        }

        for (Integer tmp : list) {
            if (tmp == max) {
                num++;
            }
        }
        System.out.println(max + " " + (num - rep / 2));

    }
}
