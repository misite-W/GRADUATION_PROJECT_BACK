package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Users;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface LoginService {

    public String test();

    public Map login(Map params);

    public String register(Users users);

    public String addSpecialist(Users users);

    public String changePassword(Map map);

}
