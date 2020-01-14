package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.News;
import com.zhongbei.graduation_project.mapper.NewsMapper;
import com.zhongbei.graduation_project.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {


    @Autowired
    private NewsMapper newsMapper;

    @Override
    public String saveNews(News news) {
       Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
       System.out.println(date);
       news.setUpdateTime(date);
       newsMapper.saveNews(news);
       return "保存成功！";
    }

    @Override
    public List<News> getNews() {
        return newsMapper.getNews();
    }

    @Override
    public void deleteNews(int id) {
        newsMapper.deleteNews(id);
    }
}
