package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Object for querying
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepartmentsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer departmentId;
	/***/
	private String departmentName;
	/***/
	private String description;
}
