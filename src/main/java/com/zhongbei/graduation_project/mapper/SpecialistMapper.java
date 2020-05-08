package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecialistMapper {



    public void deleteSpecialist(int id);

    public List<Users> getSpecialist();



}
