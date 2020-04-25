package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Comment;
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
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

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
    public List<Forum> queryForum(@RequestBody Map map){
        String queryTitle = (String)map.get("queryTitle");
        System.out.println(queryTitle);
        return forumService.queryForum(queryTitle);
    }

    @RequestMapping("/deleteForum")
    @ResponseBody
    public String deleteForum(HttpServletRequest request , @RequestBody Map map){
        int flag = (int)request.getSession().getAttribute("flag");
        if (flag == 2 ){
            return forumService.deleteForum(map);
        }
        else return "权限不足";
    }

    @RequestMapping("/saveComment")
    @ResponseBody
    public Comment saveComment(HttpServletRequest request ,@RequestBody Comment comment){
        int commentUserId = (int)request.getSession().getAttribute("userId");
        String commentUserName = (String) request.getSession().getAttribute("userName");
        comment.setCommentUserId(commentUserId);
        comment.setCommentUserName(commentUserName);
        System.out.println(comment);
        return comment;
    }
}
