package com.aiuiot.homepage.service.impl;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;
import com.aiuiot.homepage.dao.HomepageCourseDao;
import com.aiuiot.homepage.entity.HomepageCourse;
import com.aiuiot.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author aiuiot
 * @Date 2019-09-09 23:52
 **/
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private final HomepageCourseDao homepageCourseDao;

    public CourseServiceImpl(HomepageCourseDao homepageCourseDao) {
        this.homepageCourseDao = homepageCourseDao;
    }

    //获取课程
    @Override
    public CourseInfo getCourseInfo(Long id) {

        Optional<HomepageCourse> course = homepageCourseDao.findById(id);

        //如果存在返回buildCourseInfo 如果为空，返回不存在的课程 invalid
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    //获取课程列表
    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }

        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());

        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());
    }

    /**
     * 根据数据记录构造对象信息
     * @param course
     * @return
     */
    private CourseInfo buildCourseInfo(HomepageCourse course) {

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程":"实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
