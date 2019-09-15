package com.aiuiot.homepage.vo;

import com.aiuiot.homepage.CourseInfo;
import com.aiuiot.homepage.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 用户课程信息对象定义
 * @Author aiuiot
 * @Date 2019/9/14 11:41 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;               //用户信息
    private List<CourseInfo> courseInfos;   //课程信息

    //一个无效的UserCourseInfo
    public static UserCourseInfo invalid(){
        return new UserCourseInfo(UserInfo.invalid(), Collections.emptyList());
    }
}
