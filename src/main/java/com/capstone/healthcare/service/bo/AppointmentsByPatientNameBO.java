package com.capstone.healthcare.service.bo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentsByPatientNameBO {
    /***/

    private Integer appointmentId;
    /***/
    private String patientName;
    /***/
    private Integer doctorId;
    /***/
    private Date appointmentDateTime;
    /***/
    private String reasonForAppointment;
    /***/
    private String status;
    /***/
    private Integer isActive;

    public AppointmentsByPatientNameBO() {
        // Default constructor
    }

    public AppointmentsByPatientNameBO(Integer appointmentId, String patientName, Integer doctorId,
                                       Date appointmentDateTime,
                                       String reasonForAppointment, String status, Integer isActive) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.reasonForAppointment = reasonForAppointment;
        this.status = status;
        this.isActive = isActive;
    }
}
