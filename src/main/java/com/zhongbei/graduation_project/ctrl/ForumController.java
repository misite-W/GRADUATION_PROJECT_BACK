package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Forum;
import com.zhongbei.graduation_project.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ForumController {
    @Autowired
    private ForumService forumService;


    @RequestMapping("/saveForum")
    @ResponseBody
    public String saveForum(HttpServletRequest request, @RequestBody Forum forum){
        System.out.println(request.getSession().getAttribute("username"));
        String forum_userName = (String)request.getSession().getAttribute("username");
        forum.setForum_userName(forum_userName);
        System.out.println(forum.getForum_userName());
        forum.setForum_userName(forum_userName);
        return forumService.saveForum(forum);
    }

    @RequestMapping("/getForum")
    @ResponseBody
    public List<Forum> getForum(){
        return forumService.getForum();
    }

    @RequestMapping("/queryForum")
    @ResponseBody
    public List<Forum> queryForum(@RequestParam String queryTitle){
        return forumService.queryForum(queryTitle);
    }
}
