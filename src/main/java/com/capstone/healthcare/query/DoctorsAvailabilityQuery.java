package com.capstone.healthcare.query;


import lombok.Data;
import java.util.Date;
import com.capstone.healthcare.common.modules.PageInfo;
import lombok.EqualsAndHashCode;

/**
 * 实体的查询对象
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DoctorsAvailabilityQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
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
