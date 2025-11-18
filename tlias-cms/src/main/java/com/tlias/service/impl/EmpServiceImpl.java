package com.tlias.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
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
}
