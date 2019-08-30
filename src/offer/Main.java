package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) {
//        testGetLeastNumbers();
//        testFindGreatestSumOfSubArray();
//        testNumberOf1Between1AndN();
        System.out.println(allocation(2, 4));
    }

    private static void testNumberOf1Between1AndN() {
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }

    private static int NumberOf1Between1AndN_Solution(int n) {
      int res = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;

        }

        return res;
    }

    private static void testFindGreatestSumOfSubArray() {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(GreatestSumOfSubArray(array));
    }

    private static int GreatestSumOfSubArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int res = array[0];
        int maxI = array[0];
        for (int i = 1; i < array.length; i++) {
            maxI = Math.max(maxI + array[i], array[i]);
            res = Math.max(res, maxI);
        }

        return res;
    }

    private static void testGetLeastNumbers() {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }

    private static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int len = input.length;
        if (len == 0) {
            return arrayList;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int value : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.poll();
                maxHeap.offer(value);
            }
        }
        arrayList.addAll(maxHeap);

        return arrayList;
    }


    private static void help(List<List<Integer>> res, List<Integer> data, int n) {
        List<Integer> dataN = new ArrayList<>(data);
        if (n <= 0) {
            dataN.sort(Comparator.naturalOrder());
            if (!res.contains(dataN)) {
                res.add(dataN);
            }
            return;
        }
        for (int i = 0; i < dataN.size(); i++) {
            dataN.set(i, dataN.get(i) + 1);
            help(res, dataN, n - 1);
            dataN.set(i, dataN.get(i) - 1);
        }
    }

    private static int allocation(int m, int n) {
        n = n - m;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            data.add(0);
        }

        help(res, data, n);
        res.forEach(System.out::println);

        return res.size();
    }

}
