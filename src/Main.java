import java.io.File;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {

    public static void main(String[] args){
        Map<Character, BinaryOperator<Integer>> map = new HashMap<>();
        map.put('+', Integer::sum);
        map.put('-', (a, b) -> a - b);

        Integer apply = map.get('-').apply(1, 3);
        Stack<Integer> stack = new Stack<>();

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("hh");
        getTop20("E:\\lesson\\大数据理论与实践\\课件");
    }

    private static void getTop20(String directory) {
        File file = new File(directory);
        // get all files in the directory
        File[] files = file.listFiles();
        List<File> fileList = Arrays.asList(files);

        // 文件大小降序排序
        Collections.sort(fileList, (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return 1;
            } else if (o1.length() == o2.length()) {
                return 0;
            } else {
                return -1;
            }
        });

        int idx = 0;

        for (File file1 : fileList) {
            if (idx == 30) {
                break;
            }
            if (file1.isDirectory()) {
                System.out.println(file1.getTotalSpace());
            }
            double length = file1.length() / 1024.0 / 1024;
            if (length > 1) {
                System.out.println(length + "\t" + file1.getName() + "\tMark");
            } else {
                System.out.println(length + "\t" + file1.getName());
            }
            idx++;
        }

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