package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.Forum;
import com.zhongbei.graduation_project.mapper.ForumMapper;
import com.zhongbei.graduation_project.service.ForumService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumMapper forumMapper;
    @Override
    public String saveForum(Forum forum) {
        forumMapper.saveForum(forum);
        return null;
    }

    @Override
    public List<Forum> getForum()
    {
        return forumMapper.getForum();
    }

    @Override
    public void deleteForum(Forum forum) {

    }

    @Override
    public List<Forum> queryForum(String forum_title) {
        return forumMapper.queryForum(forum_title);
    }
}
