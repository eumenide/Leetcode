package gc.intro;

/**
 * 引用计数法示例：testGC()方法执行后，objA和objB会不会被GC呢？
 *
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2021-01-14
 * @copyright Copyright (c) www.alisports.com
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int ONE_MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * ONE_MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }
}
