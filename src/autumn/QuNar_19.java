package autumn;

/**
 * @author: eumes
 * @date: 2019/10/16
 **/

import java.util.Arrays;
import java.util.Scanner;

public class QuNar_19 {
    public static void main(String[] args) {
//        Solution_One();
        Solution_Two();
    }

    private static void Solution_Two(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        if (n <= 2){
            System.out.println(arr[n - 1]);
            return;
        }

        int total = 0;
        int tmp = arr[0] + 2 * arr[1];
        for (int i = n - 1; i > 1; i -= 2) {
            if (i == 2){
                total += arr[0] + arr[1] + arr[i];
                break;
            }
            total += tmp + arr[i];
        }

        System.out.println(total);
    }

    private static void Solution_One(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] cn = new long[n + 1];
        cn[0] = cn[n] = 1;
        for (int i = 1; i < n; i++) {
            cn[i] = cn[i - 1] * (n - i + 1) / i;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(cn[i] + " ");
        }
        System.out.println(cn[n]);
    }
}
