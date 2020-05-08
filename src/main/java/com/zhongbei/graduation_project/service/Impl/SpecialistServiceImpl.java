package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.Users;
import com.zhongbei.graduation_project.mapper.SpecialistMapper;
import com.zhongbei.graduation_project.service.SpecialistService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistServiceImpl implements SpecialistService {
    @Autowired
    private SpecialistMapper specialistMapper;

    @Override
    public void deleteSpecialist(int id) {
        specialistMapper.deleteSpecialist(id);
    }

    @Override
    public List<Users> getSpecialist() {
        return specialistMapper.getSpecialist();
    }
}
