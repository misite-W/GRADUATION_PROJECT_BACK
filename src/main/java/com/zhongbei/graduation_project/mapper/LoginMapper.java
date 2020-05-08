package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
@Repository
public interface LoginMapper {

    public String test();

    public Users getPassWordByUserName(String username);

    public void register(Users users);

    public void addSpecialist(Users users);

    public Users getUserNameByUserName(String userName);

    public void changePassword(@RequestParam String userName , @RequestParam String password);

    public String getPassword(String userName);


}
