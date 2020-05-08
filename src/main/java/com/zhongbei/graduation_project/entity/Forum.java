package com.zhongbei.graduation_project.entity;

public class Forum {
    int id;
    String forum_title;
    String forum_content;
    String forum_userName;
    String update_time;

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int forum_id) {
        this.id = forum_id;
    }

    public String getForum_title() {
        return forum_title;
    }

    public void setForum_title(String forum_title) {
        this.forum_title = forum_title;
    }

    public String getForum_content() {
        return forum_content;
    }

    public void setForum_content(String forum_content) {
        this.forum_content = forum_content;
    }

    public String getForum_userName() {
        return forum_userName;
    }

    public void setForum_userName(String forum_userName) {
        this.forum_userName = forum_userName;
    }
}
