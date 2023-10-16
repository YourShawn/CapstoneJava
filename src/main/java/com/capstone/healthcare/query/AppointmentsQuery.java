package com.capstone.healthcare.query;


import lombok.Data;
import java.util.Date;
import com.capstone.healthcare.common.modules.PageInfo;

/**
 * 实体的查询对象
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class AppointmentsQuery extends PageInfo{
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
