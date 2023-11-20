package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.BillingAndPaymentsDO;
import com.capstone.healthcare.dal.jpa.BillingAndPaymentsJPA;
import com.capstone.healthcare.query.BillingAndPaymentsQuery;
import com.capstone.healthcare.service.BillingAndPaymentsService;
import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;
import com.capstone.healthcare.service.convert.BillingAndPaymentsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class BillingAndPaymentsServiceImpl implements BillingAndPaymentsService {

	@Autowired
	private BillingAndPaymentsJPA billingAndPaymentsJPA;


    @Override
    public void add(BillingAndPaymentsBO billingAndPaymentsBO){
        billingAndPaymentsBO.setBillingId(null);
//        billingAndPaymentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        billingAndPaymentsBO.setCreateTime(new Date());
//        billingAndPaymentsBO.setUpdateTime( billingAndPaymentsBO.getCreateTime());
        BillingAndPaymentsDO billingAndPaymentsDO = BillingAndPaymentsConvert.toDO(billingAndPaymentsBO);
        billingAndPaymentsJPA.save(billingAndPaymentsDO);
    }

    @Override
    public void update(BillingAndPaymentsBO billingAndPaymentsBO){
		BillingAndPaymentsDO billingAndPaymentsDO = BillingAndPaymentsConvert.toDO(billingAndPaymentsBO);
        billingAndPaymentsJPA.save(billingAndPaymentsDO);
    }

    @Override
    public List<BillingAndPaymentsBO> findList(BillingAndPaymentsQuery query){
        List<BillingAndPaymentsDO> listByQuery = billingAndPaymentsJPA.findAll(this.convertExampleJPA(query));
        return BillingAndPaymentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<BillingAndPaymentsBO> findPage(BillingAndPaymentsQuery pagerCondition){
        //Setting the parameters of pagination
//        pagerCondition.setOrderBy(" ");
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<BillingAndPaymentsDO> list = billingAndPaymentsJPA.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<BillingAndPaymentsBO> pageListResult = new PageListResult(BillingAndPaymentsConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }
    /**
        *
        * @param billingAndPaymentsQuery
        * @return
        */
//    private Example convertExample(BillingAndPaymentsQuery billingAndPaymentsQuery) {
//        Example example = new Example(BillingAndPaymentsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(billingAndPaymentsQuery.getBillingId())) {
//            criteria.andEqualTo("billingId", billingAndPaymentsQuery.getBillingId());
//        }
//        return example;
//    }



    private Example<BillingAndPaymentsDO> convertExampleJPA(BillingAndPaymentsQuery query) {
        BillingAndPaymentsDO probe = new BillingAndPaymentsDO();
        if(!ObjectUtils.isEmpty(query.getBillingId())){
            probe.setBillingId(query.getBillingId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<BillingAndPaymentsDO> example = Example.of(probe, matcher);
        return example;
    }
}
