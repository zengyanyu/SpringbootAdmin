package com.zengyanyu.endpoint;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 信息
@Component
public class AppInfo implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> map = new HashMap<>();
        map.put("项目名称", "admin-service");
        map.put("springboot version", "2.7.6");
        map.put("当前时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        builder.withDetail("项目贡献者", "衍育").withDetails(map);
    }

}
