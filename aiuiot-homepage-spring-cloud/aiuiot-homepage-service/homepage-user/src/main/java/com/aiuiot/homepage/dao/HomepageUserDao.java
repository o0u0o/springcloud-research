package com.aiuiot.homepage.dao;

import com.aiuiot.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 实现对homepageuser数据表访问接口定义
 */
public interface HomepageUserDao extends JpaRepository<HomepageUser, Long> {

    /** 通过用户名查找数据记录 */
    HomepageUser findByUsername(String username);

}
