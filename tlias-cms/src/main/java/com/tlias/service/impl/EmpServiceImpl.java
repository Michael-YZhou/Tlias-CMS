package com.tlias.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tlias.mapper.EmpExprMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.*;
import com.tlias.service.EmpLogService;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

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
     * @param empQueryParam employee query param object
     * @return page result
     */
    @Override
    public PageResult<Emp> pagination(EmpQueryParam empQueryParam) {
        // set pagination criteria
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // execute query
        List<Emp> list = empMapper.list(empQueryParam);

        // wrap the list into PageInfo object
        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getList());

        // pageInfo object provides methods to access information about the current page
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * Adds an employee to the database, including their basic information and associated work experience.
     * Handles transaction management and ensures atomic operations within the process.
     *
     * @param emp The employee object containing basic details and a list of work experience records.
     */
    @Transactional(rollbackFor = {Exception.class})  // transaction management for multiple db operations
    @Override
    public void addEmp(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!exprList.isEmpty()) {
                // set empId for every empExpr object
                exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // write log for insert a new employee
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工：" + emp);
            empLogService.insertLog(empLog);
        }
    }
}
