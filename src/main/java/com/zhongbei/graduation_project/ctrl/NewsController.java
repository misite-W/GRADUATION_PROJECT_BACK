package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.News;
import com.zhongbei.graduation_project.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/saveNews")
    @ResponseBody
    public String saveNews(@RequestBody News news){
        return newsService.saveNews(news);
    }

    @RequestMapping("/deleteNews")
    @ResponseBody
    public void deleteNews(int id ){
        newsService.deleteNews(id);
    }

    @RequestMapping("/getNews")
    @ResponseBody
    public List<News> getNews(){
        return newsService.getNews();
    }

}
