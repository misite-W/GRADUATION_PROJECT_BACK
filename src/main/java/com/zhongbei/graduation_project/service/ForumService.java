package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Forum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ForumService {
    public String saveForum(Forum forum);

    public List<Forum> getForum();

    public void deleteForum(Forum forum);

    public List<Forum> queryForum(String forum_title);
}
