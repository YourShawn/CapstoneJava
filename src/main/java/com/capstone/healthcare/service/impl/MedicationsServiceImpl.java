package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.MedicationsDO;
import com.capstone.healthcare.dal.jpa.MedicationsJPA;
import com.capstone.healthcare.query.MedicationsQuery;
import com.capstone.healthcare.service.MedicationsService;
import com.capstone.healthcare.service.bo.MedicationsBO;
import com.capstone.healthcare.service.convert.MedicationsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class MedicationsServiceImpl implements MedicationsService {

	@Autowired
	private MedicationsJPA medicationsJPA;


    @Override
    public void add(MedicationsBO medicationsBO){
        medicationsBO.setMedicationId(null);
        MedicationsDO medicationsDO = MedicationsConvert.toDO(medicationsBO);
        medicationsJPA.save(medicationsDO);
    }

    @Override
    public void update(MedicationsBO medicationsBO){
		MedicationsDO medicationsDO = MedicationsConvert.toDO(medicationsBO);
        medicationsJPA.save(medicationsDO);
    }

    @Override
    public List<MedicationsBO> findList(MedicationsQuery query){
        List<MedicationsDO> listByQuery = medicationsJPA.findAll(this.convertExampleJPA(query));
        return MedicationsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<MedicationsBO> findPage(MedicationsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"medicationId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<MedicationsDO> page = medicationsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<MedicationsBO> pageListResult = new PageListResult(MedicationsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }


    private Example<MedicationsDO> convertExampleJPA(MedicationsQuery query) {
        MedicationsDO probe = new MedicationsDO();
        if (!ObjectUtils.isEmpty(query.getMedicationId())) {
            probe.setMedicationId(query.getMedicationId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<MedicationsDO> example = Example.of(probe, matcher);
        return example;
    }
    @Override
    @Transactional
    public void addBulk(List<MedicationsBO> medicationsBOList) {
        // Convert BOs to DOs and save them using JpaRepository's saveAll
        List<MedicationsDO> medicationsDOList = MedicationsConvert.toDOList(medicationsBOList);
        medicationsJPA.saveAll(medicationsDOList);
    }

}
