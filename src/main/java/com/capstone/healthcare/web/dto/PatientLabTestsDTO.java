package com.iaminca.entity.dto;

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
public class PatientLabTestsDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer patientTestId;
	/***/
	private Integer patientId;
	/***/
	private Integer doctorId;
	/***/
	private String testName;
	/***/
	private Date dateOrdered;
	/***/
	private Date dateCompleted;
	/***/
	private String testResult;
	/***/
	private String labTechnician;
	/***/
	private String notes;
	/***/
	private Integer prescriptionId;
}
