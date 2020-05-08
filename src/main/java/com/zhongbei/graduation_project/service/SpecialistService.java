package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecialistService {

    public void deleteSpecialist(int id);

    public List<Users> getSpecialist();
}
