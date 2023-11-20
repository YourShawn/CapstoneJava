package com.capstone.healthcare.service.bo;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class PrescriptionsBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer prescriptionId;
	/***/
	private String notes;
	/***/
	private Date prescriptionDate;
}
