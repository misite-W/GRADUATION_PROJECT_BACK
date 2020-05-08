package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Test;
import com.zhongbei.graduation_project.mapper.TestMapper;
import com.zhongbei.graduation_project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/saveTest")
    @ResponseBody
    public void saveTest(@RequestBody Map map){
        String testContent = (String) map.get("testContent");
        System.out.println(testContent);
        testService.saveTest(testContent);
    }

    @RequestMapping("/getTests")
    @ResponseBody
    public List<Test> getTests(@RequestBody Map map){
        int num = (int) map.get("num");
        return testService.getTests(num);
    }

    @RequestMapping("/saveScore")
    @ResponseBody
    public void saveScore(HttpServletRequest request, @RequestBody Map map){
        String name = (String) request.getSession().getAttribute("name");
        int score = (int)map.get("score");
        int userId = (int) request.getSession().getAttribute("userId");
        testService.saveScore(name,score,userId);
    }
}
