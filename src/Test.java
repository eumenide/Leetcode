import java.util.Arrays;
import java.util.List;

/**
 * 测试文件
 *
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2021-07-20
 * @copyright Copyright (c) www.alisports.com
 */
public class Test {

    public static void main(String[] args) {
        testSort();

    }

    private static void testSort() {
        //sort(1, 1, 1, 1, 1, 2, 1, 1, 1);
        //sort(3, 2, 3, 2, 1, 31);
        //sort(2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

        // exception
        sort(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2);
    }

    private static void sort(Integer... ints) {
        List<Integer> list = Arrays.asList(ints);
        System.out.println(list.size());
        list.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(list);
    }
}
