package com.aiuiot.homepage.dao;

import com.aiuiot.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * HomepageUserCourse 数据表访问接口定义
 */
public interface HomepageUserCourseDao extends JpaRepository<HomepageUserCourse, Long> {

    /** 通过用户ID寻找数据记录 */
    List<HomepageUserCourse> findAllByUserId(Long userId);



}
