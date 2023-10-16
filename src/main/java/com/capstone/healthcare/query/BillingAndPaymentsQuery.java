package com.capstone.healthcare.query;


import java.math.BigDecimal;
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
public class BillingAndPaymentsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer billingId;
	/***/
	private Integer patientId;
	/***/
	private Integer doctorId;
	/***/
	private Integer appointmentId;
	/***/
	private Date billingDate;
	/***/
	private BigDecimal totalAmount;
	/***/
	private String paymentStatus;
	/***/
	private Date paymentDate;
}
