package gc.intro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间转换工具类
 *
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2020-11-04
 * @copyright Copyright (c) www.alisports.com
 */
public class TimeUtils {

    /**
     * 时间戳转换为传入时间 00:00:00的时间Calendar
     *
     * @param timeStamp
     * @return
     */
    public static Calendar getStartOfDay(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        List<String> list = new ArrayList<String>();



        return calendar;
    }

    /**
     * 获取当日零点的日期
     */
    public static Date getStartOfToday() {
        long nowTime = System.currentTimeMillis();

        return getStartOfDay(nowTime).getTime();
    }

}
