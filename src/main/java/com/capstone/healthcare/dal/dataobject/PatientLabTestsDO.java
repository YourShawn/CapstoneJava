package com.capstone.healthcare.dal.dataobject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity(name = "patient_lab_tests")
public class PatientLabTestsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
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
