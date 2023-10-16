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
public class MedicationsBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer medicationId;
	/***/
	private Integer prescriptionId;
	/***/
	private String medicationName;
	/***/
	private String description;
	/***/
	private String dosage;
	/***/
	private String frequency;
	/***/
	private Date startDate;
	/***/
	private Date endDate;
}
