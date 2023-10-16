package com.capstone.healthcare.dal.dataobject;

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
public class MedicationsDO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer medicationid;
	/***/
	private Integer prescriptionid;
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
