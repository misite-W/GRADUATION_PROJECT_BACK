package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    public String test();

    public Users getPassWordByUserName(String username);

    public void register(Users users);

    public Users getUserNameByUserName(String userName);
}
