package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Appointment;
import com.zhongbei.graduation_project.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AppointmentMapper {
    public void saveAppointment(Appointment appointment);

    public List<Appointment> getAppointment();

    public int isAppointment(String userName);

    public void deleteAppointmentByUserName();

    public List<Appointment> checkSpecialistAppointment(String userName);

    public List<Appointment> checkStudentAppointment(String userName);

    public void clearSpecialistAppointment1(@Param("userName") String userName , @Param("date")String date,@Param("time")int time);

    public void clearSpecialistAppointment2(@Param("userName") String userName , @Param("date")String date,@Param("time")int time);

    public void clearStudentAppointment1(@Param("userName") String userName, @Param("date")String date, @Param("time") int time);

    public void clearStudentAppointment2(@Param("userName") String userName, @Param("date")String date, @Param("time") int time);

    public int isSpecialistAppointment(Appointment appointment);

    public void clearAppointment1( @Param("date")String date, @Param("time") int time);

    public void clearAppointment2( @Param("date")String date, @Param("time") int time);

    public void deleteAppointmentById(int id);

    public void consultion(int id);

    public List<Appointment> checkStudentConsultion(String userName);

    public List<Appointment> checkSpecialistConsultion(String userName);

    public List<Appointment> checkAllConsultion();
}
