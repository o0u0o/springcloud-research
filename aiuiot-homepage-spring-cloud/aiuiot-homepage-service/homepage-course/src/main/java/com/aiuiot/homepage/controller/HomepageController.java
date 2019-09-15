package com.aiuiot.homepage.controller;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;
import com.aiuiot.homepage.service.ICourseService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课程对外服务接口
 * @Author aiuiot
 * @Date 2019-09-10 00:08
 **/
@Slf4j
@RestController
public class HomepageController {

    /** 课程服务接口 通过构造函数注入*/
    @Autowired
    private final ICourseService courseService;

    public HomepageController(ICourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 不使用网关访问的路径：127.0.0:7001/homepage-course/get/course?id=
     * 使用网关访问的路径：127.0.0:9000/aiuiot/homepage-course/get/course?id=
     * 获取课程
     * @param id
     * @return
     */
    @GetMapping("/get/course")
    public CourseInfo getCourseIntro(Long id){
        //打印日志
        log.info("<homepage-course> : get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    /**
     * 通过ids获取课程信息
     * @param request
     * @return
     */
    //@RequestBody 参数绑定
    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request){
        log.info("<homepage-course> ：get course -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
