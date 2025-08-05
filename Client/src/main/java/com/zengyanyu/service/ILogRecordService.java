package com.zengyanyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zengyanyu.entity.LogRecordEntity;

/**
 * 日志记录 服务类
 *
 * @author zengyanyu
 * @since 2024-11-20
 */
public interface ILogRecordService extends IService<LogRecordEntity> {

    /**
     * 定时删除-日志记录
     */
    void removeLogRecordByConditions();
}
