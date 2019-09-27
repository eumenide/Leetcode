package autumn;

import java.util.*;

public class Tencent_19 {
    public static void main(String[] args) {
        QuestionOne();
        QuestionTwo();
        QuestionFour();
        QuestionFive();
    }

    private static void QuestionFive() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = scanner.nextInt();
            if (listA.contains(tmp)) {
                listA.remove(Integer.valueOf(tmp));
            } else {
                listA.add(tmp);
            }
        }
        for (int i = 0; i < n; i++) {
            tmp = scanner.nextInt();
            if (listB.contains(tmp)) {
                listB.remove(Integer.valueOf(tmp));
            } else {
                listB.add(tmp);
            }
        }

        int res = 0;

        for (Integer value : listA) {
            for (Integer integer : listB) {
                res ^= (value + integer);
            }
        }

        System.out.println(res);
    }

    private static void QuestionFour() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list.sort(Comparator.naturalOrder());

        int sum = list.get(0);
        int j = 1;
        System.out.println(sum);
        for (int i = 1; i < k; i++) {
            for (; j < n; j++) {
                if (list.get(j) - sum > 0) {
                    break;
                }
            }
            if (j == n) {
                System.out.println(0);
            }else {
                System.out.println(list.get(j) - sum);
                sum = list.get(j);
            }
        }


       /* int j, minJ;
        for (int i = 0; i < k; i++) {
            minJ = 0;
            for (j = 0; j < n; j++) {
                if (list.get(j) != 0) {
                    minJ = list.get(j);
                    break;
                }
            }
            System.out.println(minJ);

            if (i < k - 1) {
                list.removeIf(integer -> integer == 0);
                n = list.size();
                System.out.println(n);

                for (int l = 0; l < n; l++) {
                    if (list.get(l) != 0) {
                        list.set(l, list.get(l) - minJ);
                    }
                }
            }
        }*/

    }

    private static void QuestionOne() {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
//            int idx = 0;
//            for ( idx = 0; idx < s.length(); ++idx) {
//                if (s.charAt(idx) == '8') {
//                    break;
//                }
//            }

            int idx = s.indexOf('8');
            if (idx == -1 || n - idx < 11) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void QuestionTwo() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            m += x;

            list.add(y);
            map.put(y, x);
        }

        int res = 0;
        list.sort(Comparator.naturalOrder());

        int i = 0, j = list.size() - 1;
        int resI = map.get(list.get(0));
        int resJ = map.get(list.get(list.size() - 1));
        for (; i <= j; ) {
            res = Math.max(res, list.get(i) + list.get(j));

            if (resI < resJ) {
                i++;
                resJ -= resI;
                resI = map.get(list.get(i));
            } else if (resI == resJ) {
                i++;
                j--;
                resI = map.get(list.get(i));
                resJ = map.get(list.get(j));
            } else {
                j--;
                resI -= resJ;
                resJ = map.get(list.get(j));
            }
        }

//        int size = list.size();
//        int max = list.get(0) + list.get(size - 1);
//        for (int i = 1; i < size / 2; i++) {
//            max = Math.max(max, list.get(i) + list.get(size - i - 1));
//        }

        System.out.println(res);

    }

}

