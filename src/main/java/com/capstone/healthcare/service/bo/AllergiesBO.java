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
public class AllergiesBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer allergyId;
	/***/
	private Integer patientId;
	/***/
	private String allergenName;
	/***/
	private String allergyType;
	/***/
	private String severity;
	/***/
	private String notes;
}
