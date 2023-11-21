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
public class PrescriptionsByYearBO {
	private static final long serialVersionUID = 1L;

	/***/
	private String year;
	/***/
	private Long count;

	public PrescriptionsByYearBO(String year, Long count) {
		this.year = year;
		this.count = count;
	}
}
