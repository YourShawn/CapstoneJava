package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Table(name = "appointments")
public class AppointmentsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	private Integer appointmentId;
	/***/
	private Integer patientId;
	/***/
	private Integer doctorId;
	/***/
	private Date appointmentDateTime;
	/***/
	private String reasonForAppointment;
	/***/
	private String status;
}
