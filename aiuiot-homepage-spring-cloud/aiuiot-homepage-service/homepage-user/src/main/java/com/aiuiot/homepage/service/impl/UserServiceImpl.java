package com.aiuiot.homepage.service.impl;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.CourseInfosRequest;
import com.aiuiot.homepage.UserInfo;
import com.aiuiot.homepage.client.CourseClient;
import com.aiuiot.homepage.dao.HomepageUserCourseDao;
import com.aiuiot.homepage.dao.HomepageUserDao;
import com.aiuiot.homepage.entity.HomepageUser;
import com.aiuiot.homepage.entity.HomepageUserCourse;
import com.aiuiot.homepage.service.IUserService;
import com.aiuiot.homepage.vo.CreateUserRequest;
import com.aiuiot.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关服务实现
 * @Author aiuiot
 * @Date 2019/9/14 11:48 下午
 **/
@Slf4j
@Service
public class UserServiceImpl implements IUserService {


    private final HomepageUserDao homepageUserDao;

    private final HomepageUserCourseDao homepageUserCourseDao;

    private final CourseClient courseClient;

    @Autowired
    public UserServiceImpl(HomepageUserDao homepageUserDao,
                           HomepageUserCourseDao homepageUserCourseDao,
                           CourseClient courseClient) {
        this.homepageUserDao = homepageUserDao;
        this.homepageUserCourseDao = homepageUserCourseDao;
        this.courseClient = courseClient;
    }

    /**
     * 创建用户
     * @param request
     * @return
     */
    @Override
    public UserInfo createUser(CreateUserRequest request) {
        //判断当前的requet是否有效
        if (!request.validate()){
            //如果无效，返回invalid
            return  UserInfo.invalid();
        }

        //判断user是否相同
        HomepageUser oldUser = homepageUserDao.findByUsername(request.getUsername());
        if (null != oldUser){
            return UserInfo.invalid();
        }

        HomepageUser newUser = homepageUserDao.save(
                new HomepageUser(request.getUsername(),request.getUsername())
        );

        return new UserInfo(newUser.getId(),
                newUser.getUsername(),
                newUser.getEmail()
        );

    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        //如果不存在
        if(!user.isPresent()){
            return UserInfo.invalid();
        }

        HomepageUser curUser = user.get();
        return new UserInfo(curUser.getId(),curUser.getUsername(),curUser.getEmail());
    }

    /**
     * 根据ID获取用户以及课程信息
     * @param id
     * @return
     */
    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {

        //获取对应的用户
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        //如果不存在
        if(!user.isPresent()){
            return UserCourseInfo.invalid();
        }

        HomepageUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(),
                homepageUser.getUsername(),homepageUser.getEmail()
        );

        List<HomepageUserCourse> userCourses = homepageUserCourseDao.findAllByUserId(id);
        if(CollectionUtils.isEmpty(userCourses)){
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(userCourses.stream()
                        .map(HomepageUserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
