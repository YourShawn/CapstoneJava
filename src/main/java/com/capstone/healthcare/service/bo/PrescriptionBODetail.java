package com.capstone.healthcare.service.bo;

import lombok.Data;

import java.util.Date;

@Data
public class PrescriptionBODetail {
    /***/
    private Integer prescriptionId;
    /***/
    private String notes;
    /***/
    private Date prescriptionDate;

    private Integer medicationId;
    /***/
    private String medicationName;
    /***/
    private String description;
    /***/
    private String dosage;
    /***/
    private String frequency;
    /***/
    private Date startDate;
    /***/
    private Date endDate;

    public PrescriptionBODetail(Integer prescriptionId, String notes, Date prescriptionDate,
                                Integer medicationId, String medicationName, String description,
                                String dosage, String frequency, Date startDate, Date endDate) {
        this.prescriptionId = prescriptionId;
        this.notes = notes;
        this.prescriptionDate = prescriptionDate;
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.description = description;
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
