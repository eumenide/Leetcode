package offer;

import java.util.*;

public class Main {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
//        testGetLeastNumbers();
//        testFindGreatestSumOfSubArray();
//        testNumberOf1Between1AndN();
//        testNumberOf1Between1AndN();
//        testPrintMinNumber();
//        testGetUglyNumber_Solution();
//        testCutRope();
//        testMovingCount();
//        testHasPath();
        testMaxInWindows();


    }

    //


    // 数据流中的中位数
    private static void Insert(Integer num) {

    }

    private static Double GetMedian() {

        return 0.0;
    }

    private static void testGetMedian() {

    }

    // 把二叉树打印成多行
    private static ArrayList<ArrayList<Integer>> Print2(TreeLinkNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        helpePrint2(0, pRoot, lists);

        return lists;
    }

    private static void helpePrint2(int line, TreeLinkNode pRoot, ArrayList<ArrayList<Integer> > lists) {
        if (pRoot == null) {
            return;
        }

        if (line == lists.size()) {
            lists.add(new ArrayList<>());
        }

        lists.get(line).add(pRoot.val);

        helpePrint2(line + 1, pRoot.left, lists);
        helpePrint2(line + 1, pRoot.right, lists);
    }


    // 按之字形顺序打印二叉树
    private static ArrayList<ArrayList<Integer>> Print(TreeLinkNode pRoot) {
        Stack<TreeLinkNode> oddStack = new Stack<>();   // 奇数
        Stack<TreeLinkNode> evenStack = new Stack<>();  // 偶数
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (pRoot == null) {
            return lists;
        }
        oddStack.push(pRoot);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!oddStack.isEmpty()) {
                while (!oddStack.isEmpty()) {
                    pRoot = oddStack.pop();
                    if (pRoot != null) {
                        evenStack.push(pRoot.left);
                        evenStack.push(pRoot.right);
                        list.add(pRoot.val);
                    }
                }
            } else {
                while (!evenStack.isEmpty()) {
                    pRoot = evenStack.pop();
                    if (pRoot != null) {
                        oddStack.push(pRoot.right);
                        oddStack.push(pRoot.left);
                        list.add(pRoot.val);
                    }
                }
            }
            if (list.isEmpty()) continue;
            lists.add(list);
        }

        return lists;
    }


    // 对称的二叉树
    private static boolean isSymmetrical(TreeLinkNode pRoot) {
        Stack<TreeLinkNode> stack = new Stack<>();
        if (pRoot == null) {
            return true;
        }
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            TreeLinkNode right = stack.pop();
            TreeLinkNode left = stack.pop();

            if (right == null && left == null) {
                continue;
            }

            if (right == null || left == null || left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


    // 二叉树的下一个节点
    private static TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右节点不为空，则从右节点逐级往下寻找左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 右节点为空，则逐级往上直到自己是左节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }

        return null;
    }


    // 滑动窗口的最大值
    private static ArrayList<Integer> MaxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        if (size == 0) {
            return list;
        }

        for (int i = 0; i < num.length; i++) {
            while (!linkedList.isEmpty() && linkedList.getFirst() <= i - size) {
                linkedList.removeFirst();
            }
            while (!linkedList.isEmpty() && num[linkedList.getLast()] <= num[i]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if (i + 1 >= size) {
                list.add(num[linkedList.getFirst()]);
            }
        }

        return list;
    }

    private static void testMaxInWindows() {
        int[] num = { 2, 3, 4, 2, 6, 2, 5, 1};

        System.out.println(MaxInWindows(num, 3));
    }


    // 矩阵中的路径
    private static boolean HasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( hasPathHelper(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathHelper(char[] matrix, int rows, int cols, int r, int c, char[] str, int i, boolean[][] visited) {
        if (i == str.length) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || str[i] != matrix[r * cols + c]) {
            return false;
        }
        visited[r][c] = true;

        boolean flag =  hasPathHelper(matrix, rows, cols, r, c - 1, str, i + 1, visited) ||
                hasPathHelper(matrix, rows, cols, r, c + 1, str, i + 1, visited) ||
                hasPathHelper(matrix, rows, cols, r - 1, c, str, i + 1, visited) ||
                hasPathHelper(matrix, rows, cols, r + 1, c, str, i + 1, visited);
        visited[r][c] = false;
        return flag;
    }

    private static void testHasPath() {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str1 = "bcced".toCharArray();
        char[] str2 = "abcb".toCharArray();
        System.out.println(HasPath(matrix, 3, 4, str1));
        System.out.println(HasPath(matrix, 3, 4, str2));
    }


    // 机器人的运动范围
    private static int MovingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];

        return MovingCountHelper(threshold, rows, cols, 0, 0, visited);
    }

    private static int MovingCountHelper(int threshold, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || BitSum(r) + BitSum(c) > threshold) {
            return 0;
        }
        visited[r][c] = true;
        return MovingCountHelper(threshold, rows, cols, r, c - 1, visited) +
                MovingCountHelper(threshold, rows, cols, r, c + 1, visited) +
                MovingCountHelper(threshold, rows, cols, r - 1, c, visited) +
                MovingCountHelper(threshold, rows, cols, r + 1, c, visited) + 1;
    }

    private static int BitSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }


    // 剪绳子
    private static int CutRope(int target) {
        int a = target / 3;
        int b = target % 3;
        int result = 0;
        if (b == 0) {
            result = (int) Math.pow(3, a);
        } else if (b == 1) {
            result = (int) (Math.pow(3, a - 1) * 4);
        } else {
            result = (int) (Math.pow(3, a) * b);
        }

        return result;
    }


    //
    private static int FirstNotRepeatingChar(String str) {
        int[] arr = new int[58];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }


    private static int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int v2, v3, v5;
        for (int i = 1; i < index; i++) {
            v2 = arr[i2] * 2;
            v3 = arr[i3] * 3;
            v5 = arr[i5] * 5;
            arr[i] = Math.min(v2, Math.min(v3, v5));
            if (arr[i] == v2) i2++;
            if (arr[i] == v3) i3++;
            if (arr[i] == v5) i5++;
        }

        return arr[index - 1];
    }


    private static String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int value : numbers) {
            list.add(value);
        }
        list.sort((o1, o2) -> {
            Integer a = Integer.parseInt(o1.toString() + o2.toString());
            Integer b = Integer.parseInt(o2.toString() + o1.toString());
            return a.compareTo(b);
        });
        StringBuilder res = new StringBuilder();
        for (Integer number : list) {
            res.append(number.toString());
        }
        return res.toString();
    }


    private static int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            res += (a + 8) / 10 * i + (b + 1) * (a % 10 == 1 ? 1 : 0);
        }

        return res;
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


    private static void testMovingCount() {
        System.out.println(MovingCount(4, 4, 3));
    }

    private static void testCutRope() {
        System.out.println(CutRope(8));
    }

    private static void testFirstNotRepeatingChar() {
        System.out.println(FirstNotRepeatingChar("abcca"));
    }

    private static void testGetUglyNumber_Solution() {
        System.out.println(GetUglyNumber_Solution(21));
    }

    private static void testPrintMinNumber() {
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));
    }

    private static void testNumberOf1Between1AndN() {
        System.out.println(NumberOf1Between1AndN_Solution(21345));
    }

    private static void testFindGreatestSumOfSubArray() {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(GreatestSumOfSubArray(array));
    }

    private static void testGetLeastNumbers() {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
        System.out.println(list);
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
