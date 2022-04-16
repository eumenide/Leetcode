package gc.intro;

import java.util.Collections;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author HengAi <hengai.jy@alibaba-inc.com>
 * @date 2021-03-13
 * @copyright Copyright (c) www.alisports.com
 */
@Getter
@AllArgsConstructor
@ToString
public enum TestEnum {
    /**
     * 今日进行中的赛程
     */
    RUNNING_SCHEDULE(1,  TimeUtils.getStartOfToday()),
    ;

    /**
     * 标示值
     */
    private final Integer value;

    /**
     * 开始时间
     */
    private final Date startDate;
}
