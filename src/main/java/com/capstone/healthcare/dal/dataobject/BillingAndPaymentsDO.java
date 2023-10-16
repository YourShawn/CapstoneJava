package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Table(name = "billing_and_payments")
public class BillingAndPaymentsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
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
