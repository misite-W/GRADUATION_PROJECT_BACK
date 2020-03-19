package com.zhongbei.graduation_project.entity;

public class Forum {
    int forum_id;
    String forum_title;
    String forum_content;
    String forum_userName;

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
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
