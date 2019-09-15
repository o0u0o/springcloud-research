package com.aiuiot.homepage.service;

import com.aiuiot.homepage.UserInfo;
import com.aiuiot.homepage.vo.CreateUserRequest;
import com.aiuiot.homepage.vo.UserCourseInfo;

/**
 * 用户相关服务接口定义
 * @Author aiuiot
 * @Date 2019/9/14 11:45 下午
 **/
public interface IUserService {

    /** 创建用户 */
    UserInfo createUser(CreateUserRequest request);

    /** 根据ID获取用户信息 */
    UserInfo getUserInfo(Long id);

    /** 获取用户和课程信息 */
    UserCourseInfo getUserCourseInfo(Long id);

}
