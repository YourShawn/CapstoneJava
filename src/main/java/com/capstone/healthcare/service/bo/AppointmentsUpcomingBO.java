package com.capstone.healthcare.service.bo;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentsUpcomingBO {
    /***/
    private String appointmentDateTime;
    /***/
    private String doctorName;

    public AppointmentsUpcomingBO(String appointmentDateTime, String doctorName) {
        this.appointmentDateTime = appointmentDateTime;
        this.doctorName = doctorName;
    }
}
