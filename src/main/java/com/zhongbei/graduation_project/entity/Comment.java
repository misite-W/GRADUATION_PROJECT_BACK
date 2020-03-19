package com.zhongbei.graduation_project.entity;

public class Comment {
    int comment_id;
    String comment_content;
    int comment_userid;
    int comment_forumid;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getComment_userid() {
        return comment_userid;
    }

    public void setComment_userid(int comment_userid) {
        this.comment_userid = comment_userid;
    }

    public int getComment_forumid() {
        return comment_forumid;
    }

    public void setComment_forumid(int comment_forumid) {
        this.comment_forumid = comment_forumid;
    }
}
