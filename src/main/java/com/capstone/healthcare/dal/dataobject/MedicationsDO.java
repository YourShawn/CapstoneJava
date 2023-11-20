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
@Entity(name = "medications")
public class MedicationsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
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
