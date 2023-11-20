package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.service.convert.PrescriptionsConvert;
import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class PrescriptionsServiceImpl implements PrescriptionsService {

    @Resource
    private PrescriptionsJPA prescriptionsJPA;


    @Override
    public void add(PrescriptionsBO prescriptionsBO) {
        prescriptionsBO.setPrescriptionId(null);
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        prescriptionsJPA.save(prescriptionsDO);
    }

    @Override
    public void update(PrescriptionsBO prescriptionsBO) {
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        prescriptionsJPA.save(prescriptionsDO);
    }

    @Override
    public List<PrescriptionsBO> findList(PrescriptionsQuery query) {
        List<PrescriptionsDO> listByQuery = prescriptionsJPA.findAll(this.convertExampleJPA(query));
        return PrescriptionsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PrescriptionsBO> findPage(PrescriptionsQuery pagerCondition) {
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<PrescriptionsDO> list = prescriptionsJPA.findAll(this.convertExampleJPA(pagerCondition));
        //Setting the set of result
        PageListResult<PrescriptionsBO> pageListResult = new PageListResult(PrescriptionsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }

    /**
     * @param prescriptionsQuery
     * @return
     */
//    private Example convertExample(PrescriptionsQuery prescriptionsQuery) {
//        Example example = new Example(PrescriptionsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(prescriptionsQuery.getPrescriptionId())) {
//            criteria.andEqualTo("prescriptionId", prescriptionsQuery.getPrescriptionId());
//        }
//        return example;
//    }
    private Example<PrescriptionsDO> convertExampleJPA(PrescriptionsQuery query) {
        PrescriptionsDO probe = new PrescriptionsDO();
        if (!ObjectUtils.isEmpty(query.getPrescriptionId())) {
            probe.setPrescriptionId(query.getPrescriptionId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<PrescriptionsDO> example = Example.of(probe, matcher);
        return example;
    }


}
