package autumn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hh");
    }

    private static void Solution_1() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] res = new int[10];
        while (N-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] arr = new int[10];
            int d = a * b;
            int tmp_a, tmp_e;

            while (b > 0) {
                int c = b % 10;
                if (c != 0) {
                    tmp_a = c * a;
                    while (tmp_a > 0) {
                        tmp_e = tmp_a % 10;
                        arr[tmp_e]++;
                        tmp_a /= 10;
                    }
                }
                b = b / 10;
            }

            for (int i = 1; i < 9; i++) {
                res[i] += arr[i];
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[9]);
        }

        int max = 1;
        for (int i = 2; i < 10; i++) {
            if (res[i] > res[max]) {
                max = i;
            }
        }
        System.out.println(max);
    }

}
