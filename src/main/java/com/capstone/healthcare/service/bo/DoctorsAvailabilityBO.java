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
public class DoctorsAvailabilityBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer availabilityid;
	/***/
	private Integer doctorid;
	/***/
	private String dayofweek;
	/***/
	private Date startTime;
	/***/
	private Date endTime;
	/***/
	private Integer maximumAppointment;
	/***/
	private Integer currentAppointment;
}
