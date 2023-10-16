package com.capstone.healthcare.query;


import lombok.Data;
import java.util.Date;
import com.capstone.healthcare.common.modules.PageInfo;

/**
 * 实体的查询对象
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class PatientsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer patientId;
	/***/
	private String firstName;
	/***/
	private String lastName;
	/***/
	private String phoneNumber;
	/***/
	private String address;
	/***/
	private Date dateOfBirth;
	/***/
	private String gender;
	/***/
	private String healthCardId;
	/***/
	private Integer haveAllergies;
}
