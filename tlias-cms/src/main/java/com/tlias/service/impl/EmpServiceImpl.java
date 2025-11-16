package com.tlias.service.impl;

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

    @Override
    public PageResult<Emp> pagination(Integer page, Integer pageSize) {
        Long total = empMapper.countEmp();

        if (total > 0) {
            Integer start = (page - 1) * pageSize;
            List<Emp> rows = empMapper.findPageEmp(start, pageSize);
            return new PageResult<>(total, rows);
        } else {
            return new PageResult<>(0L, null);
        }
    }
}
