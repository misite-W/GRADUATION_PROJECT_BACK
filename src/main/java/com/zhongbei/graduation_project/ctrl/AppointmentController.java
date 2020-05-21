package com.zhongbei.graduation_project.ctrl;

import com.zhongbei.graduation_project.entity.Appointment;
import com.zhongbei.graduation_project.service.AppointmentService;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping("/saveAppointment")
    @ResponseBody
    public String saveAppointment(HttpServletRequest request, @RequestBody Appointment appointment){
        int flag = (int)request.getSession().getAttribute("flag");
        if(flag==0){
            String userName = (String)request.getSession().getAttribute("username");
            appointment.setStudent(userName);
            return appointmentService.saveAppointment(appointment);
        }
        else {
            return "对不起，您不是是学生，不能预约！";
        }
    }

    @RequestMapping("/checkMyAppointment")
    @ResponseBody
    public List<Appointment> chechMyAppointment(HttpServletRequest request ){
        int flag = (int)request.getSession().getAttribute("flag");
        String userName =
                (String)request.getSession().getAttribute("username");
        if(flag==1){
            return appointmentService.checkSpecialistAppointment(userName);
        }
        else if (flag == 0) {
            return appointmentService.checkStudentAppointment(userName);
        }
        else {
            return appointmentService.getAppointment();
        }
    }

    @RequestMapping("/clearAppointment")
    @ResponseBody
    public void clearAppointment(HttpServletRequest request){
        String userName = (String)request.getSession().getAttribute("username");
        int flag = (int)request.getSession().getAttribute("flag");
        if(flag == 1){
            appointmentService.clearSpecialistAppointment(userName);
        }
        else if(flag == 0){
            appointmentService.clearStudentAppointment(userName);
        }
        else if(flag == 2){
            appointmentService.clearAppointment();
        }
    }

    @RequestMapping("/deleteAppointmentById")
    @ResponseBody
    public String deleteAppointmentById(@RequestBody Map map){
            appointmentService.deleteAppointmentById((int)map.get("id"));
            return "删除成功！";
    }

    @RequestMapping("/consultion")
    @ResponseBody
    public String consultion(HttpServletRequest request , @RequestBody Map map){
        int flag = (int) request.getSession().getAttribute("flag");
        int id = (int)map.get("id");
        if(flag == 1){
            appointmentService.consultion(id);
            return "已添加到已咨询";
        }
        else{
            return "权限不足";
        }
    }

    @RequestMapping("checkConsultion")
    @ResponseBody
    public List<Appointment> checkConsultion(HttpServletRequest request ){
        String userName = (String)request.getSession().getAttribute("username");
        int flag = (int)request.getSession().getAttribute("flag");
        return appointmentService.checkConsultion(flag,userName);
    }

}
