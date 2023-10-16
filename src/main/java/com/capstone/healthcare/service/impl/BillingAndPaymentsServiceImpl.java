package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.BillingAndPaymentsDAO;
import com.capstone.healthcare.dal.dataobject.BillingAndPaymentsDO;
import com.capstone.healthcare.query.BillingAndPaymentsQuery;
import com.capstone.healthcare.service.BillingAndPaymentsService;
import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;
import com.capstone.healthcare.service.convert.BillingAndPaymentsConvert;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

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
	private BillingAndPaymentsDAO billingAndPaymentsDAO;


    @Override
    public int add(BillingAndPaymentsBO billingAndPaymentsBO){
//        billingAndPaymentsBO.setId(null);
//        billingAndPaymentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        billingAndPaymentsBO.setCreateTime(new Date());
//        billingAndPaymentsBO.setUpdateTime( billingAndPaymentsBO.getCreateTime());
        BillingAndPaymentsDO billingAndPaymentsDO = BillingAndPaymentsConvert.toDO(billingAndPaymentsBO);
		return billingAndPaymentsDAO.insert(billingAndPaymentsDO);
    }

    @Override
    public int update(BillingAndPaymentsBO billingAndPaymentsBO){
		BillingAndPaymentsDO billingAndPaymentsDO = BillingAndPaymentsConvert.toDO(billingAndPaymentsBO);
        return billingAndPaymentsDAO.updateByPrimaryKeySelective(billingAndPaymentsDO);
    }

    @Override
    public List<BillingAndPaymentsBO> findList(BillingAndPaymentsQuery query){
        List<BillingAndPaymentsDO> listByQuery = billingAndPaymentsDAO.selectByExample(this.convertExample(query));
        return BillingAndPaymentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<BillingAndPaymentsBO> findPage(BillingAndPaymentsQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<BillingAndPaymentsDO> list = billingAndPaymentsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<BillingAndPaymentsBO> pageListResult = new PageListResult(BillingAndPaymentsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param billingAndPaymentsQuery
        * @return
        */
    private Example convertExample(BillingAndPaymentsQuery billingAndPaymentsQuery) {
        Example example = new Example(BillingAndPaymentsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(billingAndPaymentsQuery.getBillingId())) {
            criteria.andEqualTo("billingId", billingAndPaymentsQuery.getBillingId());
        }
        return example;
    }

}
