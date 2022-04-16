package gc.intro;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 赛程推荐类型
 *
 * @author gongming <gongming.gm@alibaba-inc.com>
 * @date 2021-01-07
 * @copyright Copyright (c) www.alisports.com
 */
@Getter
@AllArgsConstructor
@ToString
public enum ATestEnum {

    /**
     * 今日进行中的赛程
     */
    RUNNING_SCHEDULE(1, getTodayDate(), true, "今日进行中赛程"),

    /**
     * 今日及今日之后未开始的赛程
     */
    NOT_START_SCHEDULE(2, getTodayDate(), true, "今日及今日之后未开始的赛程"),
    ;

    /**
     * 标示值
     */
    private final Integer value;

    /**
     * 开始时间
     */
    private final Date startDate;

    /**
     * 是否按比赛时间为升序
     */
    private final Boolean isAsc;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 今日凌晨
     */
    private static Date getTodayDate() {
        return TimeUtils.getStartOfToday();
    }
}
