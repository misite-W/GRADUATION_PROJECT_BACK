package com.zhongbei.graduation_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloSpringBootController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot(){
        return "hello SpringBOOT";
    }


}
