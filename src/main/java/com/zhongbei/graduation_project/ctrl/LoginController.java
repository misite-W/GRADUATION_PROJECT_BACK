package com.zhongbei.graduation_project.ctrl;
import com.zhongbei.graduation_project.entity.Users;
import com.zhongbei.graduation_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/test")
    @ResponseBody
    public String testConnection(@RequestBody Map params){
        return loginService.test();
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
            return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login( HttpServletRequest request, @RequestBody Map params){
        System.out.println(params);
        HttpSession session = request.getSession();
        if (loginService.login(params).get("login").equals("yes")){
            session.setAttribute("username",params.get("username"));
            session.setAttribute("password",params.get("password"));
            System.out.println(session.getAttribute("username"));
        }
        return loginService.login(params);
    }

    @RequestMapping("/register")
    @ResponseBody
    public String signIn(@RequestBody Users users){
        return loginService.register(users);
    }
}
