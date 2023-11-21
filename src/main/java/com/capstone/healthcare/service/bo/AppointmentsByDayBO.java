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

	public AppointmentsByDayBO(String timeStr, Long count) {
		String replace = timeStr.replace(",", "");
		String year = replace.substring(0, 4);
		String month = replace.substring(4, 6);
		String day = replace.substring(6, 8);
		this.day = year + "-" + month + "-"+ day;
		this.count = count;
	}
}
