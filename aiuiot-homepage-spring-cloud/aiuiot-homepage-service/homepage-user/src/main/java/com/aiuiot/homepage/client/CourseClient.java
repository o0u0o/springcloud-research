package com.aiuiot.homepage.client;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 通过 Feign 访问课程微服务
 * CourseClient 接口
 *
 * fallback 回滚策略（降级兜底策略）
 */
@FeignClient(value = "eureka-client-homepage-course", fallback = CourseClientHystrix.class) //value表示要访问的服务名
public interface CourseClient {

    //定义服务接口 获取课程信息
    @RequestMapping(value = "/homepage-course/get/course", method = RequestMethod.GET)
    CourseInfo getCOurseInfo(Long id);

    //获取多个课程信息
    @RequestMapping(value = "/homepage-course/get/course", method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);



}
