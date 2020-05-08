package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.News;
import com.zhongbei.graduation_project.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/saveNews")
    @ResponseBody
    public String saveNews(HttpServletRequest request, @RequestBody News news){
        int flag = (int)request.getSession().getAttribute("flag");
        if(flag == 2){
            return newsService.saveNews(news);
        }
        else {
            return "对不起，权限不足！";
        }
    }

    @RequestMapping("/deleteNews")
    @ResponseBody
    public void deleteNews( HttpServletRequest request ,@RequestBody Map map ){
        int flag = (int)request.getSession().getAttribute("flag");
        if(flag == 2){
            System.out.println(map.get("id"));
            int  id  = (int) map.get("id");
            newsService.deleteNews(id);
        }
    }

    @RequestMapping("/getNews")
    @ResponseBody
    public List<News> getNews(){

        return newsService.getNews();
    }

}
