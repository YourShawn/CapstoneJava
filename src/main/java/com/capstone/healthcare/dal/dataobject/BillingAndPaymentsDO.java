package com.capstone.healthcare.dal.dataobject;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class BillingAndPaymentsDO {
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
