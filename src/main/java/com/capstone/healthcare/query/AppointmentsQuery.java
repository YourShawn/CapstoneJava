package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Object for querying
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppointmentsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
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
	/***/
	private Integer isActive;
}
