package com.aiuiot.homepage.service;

import com.aiuiot.homepage.Application;
import com.aiuiot.homepage.CourseInfosRequest;
import com.aiuiot.homepage.dao.HomepageCourseDao;
import com.aiuiot.homepage.entity.HomepageCourse;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 课程服务测试
 * @Author aiuiot
 * @Date 2019-09-10 00:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

    @Autowired
    private HomepageCourseDao courseDao;

    @Autowired
    private ICourseService courseService;

//    @Test
    public void testCreateCourseInfo(){
        //模拟数据
        HomepageCourse course1 = new HomepageCourse(
                "9月淘宝新规则详细解读",
                0,
                "http//www.aiuiot.com",
                "解读淘宝最新规则"
        );

        HomepageCourse course2 = new HomepageCourse(
                "新媒体+电商实战",
                1,
                "http//www.aiuiot.com",
                "通过新媒体引入流量"
        );
        System.out.println(courseDao.saveAll(
                Arrays.asList(course1,course2)).size());
    }

    //测试用例-2 测试获取课程信息
    @Test
    public void testGetCourseInfo(){
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfo(13L)    //id为13
        ));
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfo(15L)    //id为15
        ));
    }

    //测试用例-3
    @Test
    public void testGetCourseInfos(){
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfos(
                        new CourseInfosRequest(Arrays.asList(13L,14L))
                )
        ));
    }

}
