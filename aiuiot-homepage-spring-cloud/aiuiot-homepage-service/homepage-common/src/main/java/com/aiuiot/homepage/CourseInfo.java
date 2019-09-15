package com.aiuiot.homepage;

/**
 * 课程信息
 * @Author aiuiot
 * @Date 2019-09-09 09:47
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok注解
 */
@Data
@Builder
@NoArgsConstructor //无参构造函数
@AllArgsConstructor//全参构造函数
public class CourseInfo {
    private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;

    //兜底策略
    public static CourseInfo invalid(){

        return new CourseInfo(-1L,"","", "", "");
    }
}
