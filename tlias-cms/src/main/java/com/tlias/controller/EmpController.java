package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageResult;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping
    public Result pagination(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("Employee Pagination query: page {}, pageSize {}", page, pageSize);
        PageResult<Emp> pageResult = empService.pagination(page, pageSize);
        return Result.success(pageResult);
    }
}
