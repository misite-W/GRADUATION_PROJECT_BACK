package com.zhongbei.graduation_project.service.Impl;
import com.zhongbei.graduation_project.entity.Users;
import com.zhongbei.graduation_project.mapper.LoginMapper;
import com.zhongbei.graduation_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String test() {
        return loginMapper.test();
    }

    @Override
    public Map login(Map params) {
        String userName = params.get("username").toString();
        String passWord = params.get("password").toString();
        Map map = new HashMap();
        Users user = loginMapper.getPassWordByUserName(userName);
        if(userName.length() * passWord.length() != 0){
          if(user.getPassword().equals(passWord)){
              map.put("flag",user.getFlag());
              map.put("login","yes");
              map.put("userId",user.getId());
              map.put("userName",user.getName());
              map.put("name",user.getName());
          }
          else{
              map.put("login","no");
          }
        }
        else {
            map.put("login","用户名和密码不能为空");
        }
        return map;
    }

    @Override
    public String  register(Users users) {
        if(loginMapper.getUserNameByUserName(users.getUsername()) == null){
            loginMapper.register(users);
            return "0";
        }
        else {
            return "1";
        }
    }

    @Override
    public String addSpecialist(Users users) {
         loginMapper.addSpecialist(users);
         return "添加成功";
    }

    @Override
    public String changePassword(Map map) {
        String userName = (String)map.get("userName");
        String password = (String)map.get("password");
        String rePassword = (String)map.get("rePassword");
        System.out.println(userName+password);
        if(loginMapper.getPassword(userName).equals(password)){
            loginMapper.changePassword(userName,rePassword);
            return "修改成功！";
        };
        return "原密码错误！";
    }

}
