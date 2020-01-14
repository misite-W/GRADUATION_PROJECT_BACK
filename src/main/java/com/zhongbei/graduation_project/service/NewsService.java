package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Knowledge;
import com.zhongbei.graduation_project.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public String saveNews(News news);

    public List<News> getNews();

    public void deleteNews(int id);
}
