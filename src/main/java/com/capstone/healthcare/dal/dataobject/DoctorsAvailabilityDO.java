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
@Table(name = "doctors_availability")
public class DoctorsAvailabilityDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	private Integer availabilityId;
	/***/
	private Integer doctorId;
	/***/
	private String dayOfWeek;
	/***/
	private Date startTime;
	/***/
	private Date endTime;
	/***/
	private Integer maximumAppointment;
	/***/
	private Integer currentAppointment;
}
