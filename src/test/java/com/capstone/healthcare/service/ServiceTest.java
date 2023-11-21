package com.capstone.healthcare.service;

import com.capstone.healthcare.CapstoneApplicationTests;
import com.capstone.healthcare.common.Constants;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.AppointmentHandler;
import com.capstone.healthcare.handle.DoctorsHandler;
import com.capstone.healthcare.handle.PatientHandler;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByDayBO;
import com.capstone.healthcare.service.bo.DoctorsBO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceTest extends CapstoneApplicationTests {

    @Resource
    private AppointmentsService appointmentsService;
    @Resource
    private PatientHandler patientHandler;
    @Resource
    private AppointmentHandler appointmentHandler;
    @Resource
    private DoctorsHandler doctorsHandler;
    @Resource
    private DoctorsService doctorsService;

    @Test
    void countDoc() {
        DoctorsQuery query = new DoctorsQuery();
        PageListResult<DoctorsBO> count = doctorsService.findPage(query);
        System.out.println(Constants.GSON.toJson(count));
    }
    @Test
    void contextLoads() {
        List<AppointmentsByDayBO> prescriptionGroupYear = appointmentsService.findGroupDays();
        System.out.println(Constants.GSON.toJson(prescriptionGroupYear));
        AppointmentsQuery query = new AppointmentsQuery();
        PageListResult<AppointmentsBO> page = appointmentsService.findPage(query);
        System.out.println(Constants.GSON.toJson(page));
    }

    @Test
    void count() {
        Long count = patientHandler.count();
        System.out.println(Constants.GSON.toJson(count));
    }

    @Test
    void countAppointment() {
        Long count = appointmentHandler.count();
        System.out.println(Constants.GSON.toJson(count));
    }
    @Test
    void countDoctor() {
        Long count = doctorsHandler.count();
        System.out.println(Constants.GSON.toJson(count));
    }
}
