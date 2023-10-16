package com.capstone.healthcare.service.bo;

import lombok.Data;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class AppointmentsBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer appointmentid;
	/***/
	private Integer patientid;
	/***/
	private Integer doctorid;
	/***/
	private Date appointmentDateTime;
	/***/
	private String reasonForAppointment;
	/***/
	private String status;
}
