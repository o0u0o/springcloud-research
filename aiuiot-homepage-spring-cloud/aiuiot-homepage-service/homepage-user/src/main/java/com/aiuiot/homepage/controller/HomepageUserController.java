package com.aiuiot.homepage.controller;

import com.aiuiot.homepage.UserInfo;
import com.aiuiot.homepage.service.IUserService;
import com.aiuiot.homepage.vo.CreateUserRequest;
import com.aiuiot.homepage.vo.UserCourseInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务对外接口
 * @Author aiuiot
 * @Date 2019/9/15 12:16 上午
 **/
@Slf4j
@RestController
public class HomepageUserController {

    private final IUserService userService;

    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     * @param request
     * @return
     */
    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        //打印日志,以JSON方式打印
        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id){
        //打印日志
        log.info("<homepage-user: get user -> {}>", id);
        return userService.getUserInfo(id);
    }

    /**
     * 获取用户以及课程信息
     * @param id
     * @return
     */
    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {
        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }

}
