package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Collect;
import com.zhongbei.graduation_project.entity.Comment;
import com.zhongbei.graduation_project.entity.Forum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface ForumMapper {
    public void saveForum(Forum forum);

    public List<Forum> getForum();

    public void deleteForumById(int id);

    public List<Forum> queryForum(String forum_title);

    public void saveComment(Comment comment);

    public List<Comment> getComments(int forumId);

    public List<Integer> getForumIdByUserId(int userId);

    public List<Forum> getForumById(int forumId);

    public void collectForum(Collect collect);

    public void deletMyCollectByForumId(@RequestParam int forumId , @RequestParam int userId);
}
