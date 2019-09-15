package com.aiuiot.homepage.service;

import com.aiuiot.homepage.Applicatin;
import com.aiuiot.homepage.dao.HomepageUserCourseDao;
import com.aiuiot.homepage.entity.HomepageUserCourse;
import com.aiuiot.homepage.vo.CreateUserRequest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 用户服务测试用例
 * @Author aiuiot
 * @Date 2019/9/15 12:31 上午
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Applicatin.class})
public class HomepageUserServiceTest {

    @Autowired
    private  IUserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Test
    //@Transactional //执行后会回滚，并不会真的向数据库插入信息
    public void testCreateUser(){
        System.out.println(JSON.toJSONString(
                userService.createUser(
                        new CreateUserRequest("ZerOneth","zeronrth@aiuiot.com")
                )
        ));
    }

    @Test
    public void testGetUserInfo(){
        System.out.println(JSON.toJSONString(
                userService.getUserInfo(9L)
        ));
    }

    @Test
    public void testCreateHomepageUserCourse(){
        //模拟数据11数据course1 & course 2
        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(9L);
        course1.setCourseId(13L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(9L);
        course2.setCourseId(14L);

        System.out.println(userCourseDao.saveAll(Arrays.asList(course1,course2)).size());
    }
}
