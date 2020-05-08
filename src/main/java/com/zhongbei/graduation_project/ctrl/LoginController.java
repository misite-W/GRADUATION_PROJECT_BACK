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
            session.setAttribute("flag",loginService.login(params).get("flag"));
            session.setAttribute("userId",loginService.login(params).get("userId"));
            session.setAttribute("userName",loginService.login(params).get("userName"));
            session.setAttribute("name",loginService.login(params).get("name"));
            System.out.println(session.getAttribute("username"));
            System.out.println(session.getAttribute("flag"));
        }
        return loginService.login(params);
    }

    @RequestMapping("/register")
    @ResponseBody
    public String signIn(@RequestBody Users users){
        return loginService.register(users);
    }

    @RequestMapping("/addSpecialist")
    @ResponseBody
    public String addSpecialist(HttpServletRequest request ,@RequestBody Users users){
        int flag = (int)request.getSession().getAttribute("flag");
        if(flag == 2){
            return loginService.addSpecialist(users);
        }
        else {
            return "权限不足";
        }
    }


    @RequestMapping("/changePassword")
    @ResponseBody
    public String changePassword(@RequestBody Map param){
        return loginService.changePassword(param);
    }

}
