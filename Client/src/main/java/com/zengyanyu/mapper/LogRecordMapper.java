package com.zengyanyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zengyanyu.entity.LogRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 日志记录 Mapper 接口
 *
 * @author zengyanyu
 * @since 2024-11-20
 */
@Mapper
public interface LogRecordMapper extends BaseMapper<LogRecordEntity> {

    /**
     * @param requestTime
     * @return
     */
    List<LogRecordEntity> getLogRecordByCondition(LocalDateTime requestTime);
}
