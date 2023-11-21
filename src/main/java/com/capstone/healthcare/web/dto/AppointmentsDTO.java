package com.capstone.healthcare.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class AppointmentsDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer appointmentId;
	/***/
	private Integer patientId;
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
}
