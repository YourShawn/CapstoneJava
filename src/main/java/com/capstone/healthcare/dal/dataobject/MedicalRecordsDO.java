package com.capstone.healthcare.dal.dataobject;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Entity(name = "medical_records")
public class MedicalRecordsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
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
