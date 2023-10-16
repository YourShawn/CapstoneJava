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
public class MedicalRecordsBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer recordId;
	/***/
	private Integer patientId;
	/***/
	private Integer doctorId;
	/***/
	private Date dateOfVisit;
	/***/
	private String diagnosis;
	/***/
	private String treatment;
	/***/
	private Integer prescriptionId;
	/***/
	private String visitStatus;
}
