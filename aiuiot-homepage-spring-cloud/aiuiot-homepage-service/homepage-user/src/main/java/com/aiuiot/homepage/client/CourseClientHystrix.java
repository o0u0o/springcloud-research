package com.aiuiot.homepage.client;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级策略
 * @Author aiuiot
 * @Date 2019/9/14 11:33 下午
 **/
@Component
public class CourseClientHystrix implements CourseClient{

    @Override
    public CourseInfo getCOurseInfo(Long id) {
        //此处可打印错误日志，待写
        return CourseInfo.invalid();//返回invalid
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();//反馈空列表
    }
}
