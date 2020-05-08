package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AppointmentService {
    public String saveAppointment(Appointment appointment);

    public List<Appointment> getAppointment();

    public int isAppointment(String userName);

    public void deleteAppointment(String userName);

    public List<Appointment> checkSpecialistAppointment(String userName);

    public List<Appointment> checkStudentAppointment(String userName);

    public void clearSpecialistAppointment(String userName);

    public void clearStudentAppointment(String userName);

    public void clearAppointment();

    public void deleteAppointmentById(int id);

    public void consultion(int id);

    public List<Appointment> checkConsultion(int flag, String userName);



}
