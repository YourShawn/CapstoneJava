package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Object for querying
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LaboratoryTestsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer testId;
	/***/
	private String testName;
	/***/
	private String description;
	/***/
	private BigDecimal cost;
}
