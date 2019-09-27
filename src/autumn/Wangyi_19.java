package autumn;

import java.util.Scanner;

public class Wangyi_19 {
    public static void main(String[] args) {
//        QuesOne();
//        QuesTwo();
//        QuesThree();
        QuesFour();
    }

    private static void QuesOne() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = n / 9;
            int k = n % 9;
            String s = "";
            while (m-- > 0) {
                s += "9";
            }
            if (k != 0) {
                s = k + s;
            }
            System.out.println(s);
        }
    }

    private static void QuesTwo() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long p = scanner.nextLong();
            int q = scanner.nextInt();

            int res = 0;
            while (B > A) {
                res++;
                if (A + p >= B) {
                    A += p;
                } else {
                    p *= q;
                }
            }

            System.out.println(res);

        }
    }

    private static void QuesThree() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int len = 1;
            int sum = arr[0];
            int preIdx = 0;
            int tmp = 1;
            for (int i = 1; i < n;) {
                if (arr[i] >= sum) {
                    tmp++;
                    sum += arr[i];
                    i++;
                } else {
                    len = Math.max(len, tmp);
                    sum -= arr[preIdx];
                    preIdx++;
                    tmp--;
                }
            }

            System.out.println(len);
        }
    }

    private static void QuesFour() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] > arr[j]) {
//                    sum += (j - i);
//                }
//            }
//        }
        count(arr, 0, arr.length - 1);

        System.out.println(distance);

    }

    private static int distance = 0;

    private static void merge(int[] arr, int left, int right, int mid) {
        int[] tmpA = new int[arr.length];
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            tmpA[k] = arr[k];
        }
        int k = left;
        for (; k <= right && i <= mid && j <= right; k++) {
            if (arr[i] <= arr[j]) {
                arr[k] = tmpA[i];
                i++;
            }else {
                arr[k] = tmpA[j];
                distance += (j - i + 1) * (j - i) / 2;
                j++;
            }
        }
        while (i <= mid) {
            distance += (j - i + 1) * (j - i) / 2;
            arr[k] = tmpA[i];
            i++;
            k++;
        }
        while (j <= right) {
            arr[k] = tmpA[j];
            k++;
            j++;
        }
    }

    private static void count(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            count(arr, left, mid);
            count(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }

}
