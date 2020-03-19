package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Forum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ForumMapper {
    public void saveForum(Forum forum);

    public List<Forum> getForum();

    public void deleteForum(Forum forum);

    public List<Forum> queryForum(String forum_title);
}
