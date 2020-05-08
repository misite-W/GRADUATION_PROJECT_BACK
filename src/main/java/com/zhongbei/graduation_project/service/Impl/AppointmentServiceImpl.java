package com.zhongbei.graduation_project.service.Impl;
import com.zhongbei.graduation_project.entity.Appointment;
import com.zhongbei.graduation_project.mapper.AppointmentMapper;
import com.zhongbei.graduation_project.mapper.LoginMapper;
import com.zhongbei.graduation_project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public String saveAppointment(Appointment appointment) {
        System.out.println("========="+appointment);
        //该学生是否有预约
        if (appointmentMapper.isAppointment(appointment.getStudent())==0){
            //是否选取时间
            if(appointment.getDate()!=null && appointment.getTime() != 0) {
                //当前时间该专家是否有预约
                if (appointmentMapper.isSpecialistAppointment(appointment) == 0) {
                    appointmentMapper.saveAppointment(appointment);
                    return "预约成功！";
                } else {
                    return "对不起，该时间段已经有人预约";
                }
            }else {
                return "您未选取预约时间";
            }
        }
        else {
            System.out.println(appointmentMapper.isAppointment(appointment.getStudent()));
            return "您已经有预约，不能重复预约！";
        }

    }

    @Override
    public List<Appointment> getAppointment() {
        return appointmentMapper.getAppointment();
    }

    @Override
    public int isAppointment(String userName) {
        return 0;
    }

    @Override
    public void deleteAppointment(String userName) {

    }

    @Override
    public List<Appointment> checkSpecialistAppointment(String userName) {
        return appointmentMapper.checkSpecialistAppointment(userName);
    }

    @Override
    public List<Appointment> checkStudentAppointment(String userName) {
        return appointmentMapper.checkStudentAppointment(userName);
    }

    @Override
    public void clearSpecialistAppointment(String userName) {
//          int year=c.get(Calendar.YEAR);
//          int month=c.get(Calendar.MONTH)+1;
//          int date=c.get(Calendar.DATE);
          Date d = new Date();
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String date = simpleDateFormat.format(d);
          Calendar c = Calendar.getInstance();
          int hour = c.get(Calendar.HOUR_OF_DAY);
          int minute = c.get(Calendar.MINUTE);
          int time=0;
          if((hour==9 && minute>30)||(hour==10)||(hour==11&&minute<=30)){
               time = 1;
          }
          else if((hour==11&&minute>=30)||(hour>=12&&hour<15)||(hour==15&&minute<30)){
               time =2 ;
          }
          else if((hour==15&&minute>30)||(hour==16)||(hour==17&&minute<30)){
              time = 3 ;
          }
          else if((hour==17&&minute>30)||(hour>17)){
              time = 4 ;
          }
          System.out.println("hour:"+hour+"minute:"+minute+"time:"+time);
          appointmentMapper.clearSpecialistAppointment1(userName,date,time);
          appointmentMapper.clearSpecialistAppointment2(userName,date,time);
    }

    @Override
    public void clearStudentAppointment(String userName) {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(d);
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int time=0;
        if((hour==9 && minute>30)||(hour==10)||(hour==11&&minute<=30)){
            time = 1;
        }
        else if((hour==11&&minute>=30)||(hour>=12&&hour<15)||(hour==15&&minute<30)){
            time =2 ;
        }
        else if((hour==15&&minute>30)||(hour==16)||(hour==17&&minute<30)){
            time = 3 ;
        }
        else if((hour==17&&minute>30)||(hour>17)){
            time = 4 ;
        }
        System.out.println("hour:"+hour+"minute:"+minute+"time:"+time);
        appointmentMapper.clearStudentAppointment1(userName,date,time);
        appointmentMapper.clearStudentAppointment2(userName,date,time);
    }

    @Override
    public void clearAppointment() {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(d);

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int time=0;
        if((hour==9 && minute>30)||(hour==10)||(hour==11&&minute<=30)){
            time = 1;
        }
        else if((hour==11&&minute>=30)||(hour>=12&&hour<15)||(hour==15&&minute<30)){
            time =2 ;
        }
        else if((hour==15&&minute>30)||(hour==16)||(hour==17&&minute<30)){
            time = 3 ;
        }
        else if((hour==17&&minute>30)||(hour>17)){
            time = 4 ;
        }
        appointmentMapper.clearAppointment1(date,time);
        appointmentMapper.clearAppointment2(date,time);
    }

    @Override
    public void deleteAppointmentById(int id) {
        appointmentMapper.deleteAppointmentById(id);
    }

    @Override
    public void consultion(int id) {
        appointmentMapper.consultion(id);
    }

    @Override
    public List<Appointment> checkConsultion(int flag, String userName) {
        if(flag == 0){
            return appointmentMapper.checkStudentConsultion(userName);
        }
        else if(flag == 1){
            return appointmentMapper.checkSpecialistConsultion(userName);
        }
        else {
            return appointmentMapper.checkAllConsultion();
        }
    }




}
