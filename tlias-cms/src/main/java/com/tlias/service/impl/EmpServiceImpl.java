package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.PageResult;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageResult<Emp> pagination(@RequestParam Integer page, Integer pageSize) {
//        Long total = empMapper.countEmp();
//
//        if (total > 0) {
//            Integer start = (page - 1) * pageSize;
//            List<Emp> rows = empMapper.findPageEmp(start, pageSize);
//            return new PageResult<>(total, rows);
//        } else {
//            return new PageResult<>(0L, null);
//        }
//    }

    /**
     * employee pagination query using pagehelper
     * @param page page number
     * @param pageSize page size
     * @return page result
     */
    @Override
    public PageResult<Emp> pagination(Integer page, Integer pageSize) {
        //
        PageHelper.startPage(page, pageSize);

        List<Emp> list = empMapper.list();

        Page<Emp> p = (Page<Emp>) list;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
