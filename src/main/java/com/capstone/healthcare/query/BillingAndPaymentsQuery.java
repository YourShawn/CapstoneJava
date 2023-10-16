package com.capstone.healthcare.query;


import java.math.BigDecimal;
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
public class BillingAndPaymentsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer billingid;
	/***/
	private Integer patientid;
	/***/
	private Integer doctorid;
	/***/
	private Integer appointmentid;
	/***/
	private Date billingDate;
	/***/
	private BigDecimal totalAmount;
	/***/
	private String paymentStatus;
	/***/
	private Date paymentDate;
}
