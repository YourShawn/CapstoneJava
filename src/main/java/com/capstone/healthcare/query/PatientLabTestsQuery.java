package com.capstone.healthcare.query;


import lombok.Data;
import java.util.Date;
import com.capstone.healthcare.common.modules.PageInfo;
import lombok.EqualsAndHashCode;

/**
 * 实体的查询对象
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PatientLabTestsQuery extends PageInfo{
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
