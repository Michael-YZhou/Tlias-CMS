package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.JobOption;
import com.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//将其交给IOC容器管理
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        //1.查询员工数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();

        //2.创建两个集合，分别存储数据 最后需要tolist（）
        List<Object> jobList = list.stream().map(datamap -> datamap.get("pos")).toList();
        List<Object> dataList = list.stream().map(datamap -> datamap.get("num")).toList();

        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}