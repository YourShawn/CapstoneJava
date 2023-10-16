package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.NursesDAO;
import com.capstone.healthcare.dal.dataobject.NursesDO;
import com.capstone.healthcare.query.NursesQuery;
import com.capstone.healthcare.service.NursesService;
import com.capstone.healthcare.service.bo.NursesBO;
import com.capstone.healthcare.service.convert.NursesConvert;
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
public class NursesServiceImpl implements NursesService {

	@Autowired
	private NursesDAO nursesDAO;


    @Override
    public int add(NursesBO nursesBO){
        NursesDO nursesDO = NursesConvert.toDO(nursesBO);
		return nursesDAO.insert(nursesDO);
    }

    @Override
    public int update(NursesBO nursesBO){
		NursesDO nursesDO = NursesConvert.toDO(nursesBO);
        return nursesDAO.updateByPrimaryKeySelective(nursesDO);
    }

    @Override
    public List<NursesBO> findList(NursesQuery query){
        List<NursesDO> listByQuery = nursesDAO.selectByExample(this.convertExample(query));
        return NursesConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<NursesBO> findPage(NursesQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<NursesDO> list = nursesDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<NursesBO> pageListResult = new PageListResult(NursesConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param nursesQuery
        * @return
        */
    private Example convertExample(NursesQuery nursesQuery) {
        Example example = new Example(NursesDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(nursesQuery.getNurseId())) {
            criteria.andEqualTo("nurseId", nursesQuery.getNurseId());
        }
        return example;
    }

}
