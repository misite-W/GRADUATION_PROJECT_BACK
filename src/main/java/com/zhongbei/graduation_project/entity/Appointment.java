package com.zhongbei.graduation_project.entity;

import java.util.Date;

public class Appointment {

    int id;
    String student;
    String specialist;
    String date;
    int time;
    String qq;
    int delete_flag;
    int consultion_flag;

    public int getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }

    public int getConsultion_flag() {
        return consultion_flag;
    }

    public void setConsultion_flag(int consultion_flag) {
        this.consultion_flag = consultion_flag;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", student='" + student + '\'' +
                ", specialist='" + specialist + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                '}';
    }
}
