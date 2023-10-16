package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import java.util.Date;

/**
 * 实体的查询对象
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class PatientLabTestsQuery extends PageInfo {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer patientTestid;
	/***/
	private Integer patientid;
	/***/
	private Integer doctorid;
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
	private Integer prescriptionid;
}
