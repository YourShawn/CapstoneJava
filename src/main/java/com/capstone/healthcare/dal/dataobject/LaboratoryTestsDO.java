package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Entity(name = "laboratory_tests")
public class LaboratoryTestsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	private Integer testId;
	/***/
	private String testName;
	/***/
	private String description;
	/***/
	private BigDecimal cost;
}
