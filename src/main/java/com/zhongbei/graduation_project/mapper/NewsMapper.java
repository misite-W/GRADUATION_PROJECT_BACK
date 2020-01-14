package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Knowledge;
import com.zhongbei.graduation_project.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    public void saveNews(News news);

    public List<News> getNews();

    public void deleteNews(int id);
}
