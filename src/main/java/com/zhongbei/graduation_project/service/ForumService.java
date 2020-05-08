package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Comment;
import com.zhongbei.graduation_project.entity.Forum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ForumService {
    public String saveForum(Forum forum);

    public List<Forum> getForum();

    public String deleteForum(Map map);

    public List<Forum> queryForum(String forum_title);

    public void saveComment(Comment comment);

    public List<Comment> getComments(int forumId);

    public List<Forum> getCollectByUserId(int userId);

    public String collectForum(int forumId, int userId);

    public String deletMyCollectByForumId(int forumId, int UserId);
}
