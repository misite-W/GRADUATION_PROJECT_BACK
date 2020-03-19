package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Knowledge;
import com.zhongbei.graduation_project.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping("/saveKnowledge")
    @ResponseBody
    public String saveKnowledge(@RequestBody Knowledge knowledge){
        System.out.println("==============");
        return knowledgeService.saveKnowledge(knowledge);
    }

    @RequestMapping("/getKnowledge")
    @ResponseBody
    public List<Knowledge> getKnowledge(){
        return knowledgeService.getKnowledge();
    }

    @RequestMapping("/deleteKnowledge")
    @ResponseBody
    public String deleteKnowledge(@RequestBody Map map){
        knowledgeService.deleteKnowledge((int)map.get("id"));
        return "删除成功！";
    }
}
