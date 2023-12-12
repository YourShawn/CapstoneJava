package com.capstone.healthcare.web.dto;

import lombok.Data;

@Data
public class DoctorsListDTO {
    /***/
    private Integer doctorId;
    /***/
    private String doctorName;

    public DoctorsListDTO(Integer doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }
}
