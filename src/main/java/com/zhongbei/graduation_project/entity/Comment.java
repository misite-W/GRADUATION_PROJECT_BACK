package com.zhongbei.graduation_project.entity;

public class Comment {
    int commentId;
    String commentContent;
    int commentUserId;
    int commentForumId;
    long commentTime;
    String commentUserName;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public int getCommentForumId() {
        return commentForumId;
    }

    public void setCommentForumId(int commentForumId) {
        this.commentForumId = commentForumId;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", commentUserId=" + commentUserId +
                ", commentForumId=" + commentForumId +
                ", commentTime='" + commentTime + '\'' +
                ", commentUserName='" + commentUserName + '\'' +
                '}';
    }
}
