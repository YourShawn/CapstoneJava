package com.capstone.healthcare.service.bo;

import lombok.Data;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class AppointmentsByDayBO {
	private static final long serialVersionUID = 1L;

	/***/
	private String day;
	/***/
	private Long count;

	public AppointmentsByDayBO(String day, Long count) {
		this.day = day;
		this.count = count;
	}
}
