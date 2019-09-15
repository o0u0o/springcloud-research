package com.aiuiot.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本的用户信息
 * @Author aiuiot
 * @Date 2019-09-09 09:44
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String username;
    private String email;

    public static UserInfo invalid(){
        return new UserInfo(-1L,"","");
    }
}
