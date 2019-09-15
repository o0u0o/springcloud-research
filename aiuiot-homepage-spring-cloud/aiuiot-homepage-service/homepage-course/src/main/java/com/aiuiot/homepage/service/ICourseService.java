package com.aiuiot.homepage.service;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;

import java.util.List;

/**
 * 课程相关服务接口定义
 */
public interface ICourseService {
    /**
     * 通过id获取课程信息
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过 ids 获取课程信息
     * */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
