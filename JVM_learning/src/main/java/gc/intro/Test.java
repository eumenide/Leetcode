package gc.intro;

/**
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2021-03-13
 * @copyright Copyright (c) www.alisports.com
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(TestEnum.RUNNING_SCHEDULE);

        Thread.sleep(1000);

        System.out.println(TestEnum.RUNNING_SCHEDULE);

        Thread.sleep(5000);
        System.out.println(TestEnum.RUNNING_SCHEDULE);

        System.out.println(ATestEnum.RUNNING_SCHEDULE);

        Thread.sleep(1000);

        System.out.println(ATestEnum.RUNNING_SCHEDULE);

        Thread.sleep(5000);
        System.out.println(ATestEnum.RUNNING_SCHEDULE);

    }
}
