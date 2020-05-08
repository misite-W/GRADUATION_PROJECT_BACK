package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Knowledge;
import com.zhongbei.graduation_project.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping("/saveKnowledge")
    @ResponseBody
    public String saveKnowledge(HttpServletRequest request, @RequestBody Knowledge knowledge){
        int flag = (int)request.getSession().getAttribute("flag");
        System.out.println(flag);
        if(flag == 2){
            return knowledgeService.saveKnowledge(knowledge);
        }
        else {
            return "对不起，您的权限不足";
        }
    }

    @RequestMapping("/getKnowledge")
    @ResponseBody
    public List<Knowledge> getKnowledge(){
        return knowledgeService.getKnowledge();
    }

    @RequestMapping("/deleteKnowledge")
    @ResponseBody
    public String deleteKnowledge(HttpServletRequest request ,@RequestBody Map map){
        int flag = (int)request.getSession().getAttribute("flag");
        if (flag == 2){
            knowledgeService.deleteKnowledge((int)map.get("id"));
            return "删除成功！";
        }
        else {
            return "对不起，权限不足!";
        }
    }
}
