package com.aiuiot.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 创建用户请求对象定义
 * @Author aiuiot
 * @Date 2019/9/14 11:37 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String email;

    /** 请求有效性验证 */
    public boolean validate(){
        //都不允许为空
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
