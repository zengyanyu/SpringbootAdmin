package com.zengyanyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zengyanyu.entity.LogRecordEntity;
import com.zengyanyu.mapper.LogRecordMapper;
import com.zengyanyu.service.ILogRecordService;
import com.zengyanyu.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * 日志记录 服务实现类
 *
 * @author zengyanyu
 * @since 2024-11-20
 */
@Service
@Transactional
public class LogRecordServiceImpl extends ServiceImpl<LogRecordMapper, LogRecordEntity> implements ILogRecordService {

    /**
     * 定时删除日志记录
     */
    @Override
    public void removeLogRecordByConditions() {
        // 获取当前时间
        LocalDateTime now = DateUtils.getCurrentTime();
        // 当前时间减去5天
        LocalDateTime fiveDaysAgo = now.minus(5, ChronoUnit.DAYS);
        List<LogRecordEntity> logRecordEntityList = this.baseMapper.getLogRecordByCondition(fiveDaysAgo);
        if (null != logRecordEntityList && logRecordEntityList.size() > 0) {
            this.removeBatchByIds(logRecordEntityList);
        }
    }

}
