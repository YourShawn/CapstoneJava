package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.AppointmentsDAO;
import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.convert.AppointmentsConvert;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.ObjectUtils;

/**
 * 
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class AppointmentsServiceImpl implements AppointmentsService {

	@Autowired
	private AppointmentsDAO appointmentsDAO;


    @Override
    public int add(AppointmentsBO appointmentsBO){
//        appointmentsBO.setId(null);
//        appointmentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        appointmentsBO.setCreateTime(new Date());
//        appointmentsBO.setUpdateTime( appointmentsBO.getCreateTime());
        AppointmentsDO appointmentsDO = AppointmentsConvert.toDO(appointmentsBO);
		return appointmentsDAO.insert(appointmentsDO);
    }

    @Override
    public int update(AppointmentsBO appointmentsBO){
		AppointmentsDO appointmentsDO = AppointmentsConvert.toDO(appointmentsBO);
        return appointmentsDAO.updateByPrimaryKeySelective(appointmentsDO);
    }

    @Override
    public List<AppointmentsBO> findList(AppointmentsQuery query){
        List<AppointmentsDO> listByQuery = appointmentsDAO.selectByExample(this.convertExample(query));
        return AppointmentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<AppointmentsBO> findPage(AppointmentsQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<AppointmentsDO> list = appointmentsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<AppointmentsBO> pageListResult = new PageListResult(AppointmentsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param appointmentsQuery
        * @return
        */
    private Example convertExample(AppointmentsQuery appointmentsQuery) {
        Example example = new Example(AppointmentsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(appointmentsQuery.getAppointmentId())) {
            criteria.andEqualTo("appointmentId", appointmentsQuery.getAppointmentId());
        }

        if(!ObjectUtils.isEmpty(appointmentsQuery.getDoctorId())) {
            criteria.andEqualTo("doctorId",appointmentsQuery.getDoctorId());
        }
        return example;
    }

}
