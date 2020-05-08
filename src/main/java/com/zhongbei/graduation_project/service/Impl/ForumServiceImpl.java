package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.Collect;
import com.zhongbei.graduation_project.entity.Comment;
import com.zhongbei.graduation_project.entity.Forum;
import com.zhongbei.graduation_project.mapper.ForumMapper;
import com.zhongbei.graduation_project.service.ForumService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumMapper forumMapper;
    @Override
    public String saveForum(Forum forum) {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(d);
        forum.setUpdate_time(date);
        forumMapper.saveForum(forum);
        return null;
    }

    @Override
    public List<Forum> getForum()
    {
        return forumMapper.getForum();
    }

    @Override
    public String deleteForum(Map map) {
        int id = (int)map.get("id");
        forumMapper.deleteForumById(id);
        return "删除成功";
    }

    @Override
    public List<Forum> queryForum(String forum_title) {
        return forumMapper.queryForum(forum_title);
    }

    @Override
    public void saveComment(Comment comment) {
            forumMapper.saveComment(comment);
    }

    @Override
    public List<Comment> getComments(int forumId) {
        List<Comment> comments= new ArrayList<>();
        comments.addAll(forumMapper.getComments(forumId));
        for(Comment comment : comments){
            long time = comment.getCommentTime();
            long date = (long) new Date().getTime();
            time=(date-time)/1000;
            int s;
            System.out.println(time);
            String time1;
            if(time<60*10){//十分钟内
                time1 = "刚刚";
            }else if((time<60*60)&&(time>=60*10)){
                //超过十分钟少于1小时
                s = (int)Math.floor(time/60);
                time1 = s+"分钟前";
            }else if((time<60*60*24)&&(time>=60*60)){
                //超过1小时少于24小时
                s = (int)Math.floor(time/60/60);
                time1 = s+"小时前";
            }else if((time<60*60*24*30)&&(time>=60*60*24)){
                //超过1天少于30天内
                s = (int)Math.floor(time/60/60/24);
                time1 = s+"天前";
            }else{
                //超过30天ddd
                time1 ="很久以前";
            }
            comment.setTime(time1);
        }
        return comments;

    }

    @Override
    public List<Forum> getCollectByUserId(int userId) {
        List<Integer> lists = forumMapper.getForumIdByUserId(userId);
        List<Forum> forumList  = new ArrayList<>();
        for (int list : lists){
            forumList.addAll(forumMapper.getForumById(list));
        }
        return forumList;
    }

    @Override
    public String collectForum(int forumId, int userId) {
        Collect collect = new Collect();
        collect.setForumId(forumId);
        collect.setUserId(userId);
        forumMapper.collectForum(collect);
        return "收藏成功！";
    }

    @Override
    public String deletMyCollectByForumId(int forumId, int UserId) {
        forumMapper.deletMyCollectByForumId( forumId, UserId);
        return "删除成功";
    }
}
