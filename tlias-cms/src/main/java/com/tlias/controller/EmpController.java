package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PageResult;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

//    @GetMapping
//    public Result pagination(@RequestParam(defaultValue = "1") Integer page,
//                             @RequestParam(defaultValue = "10") Integer pageSize,
//                             String name, Integer gender,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("Employee Pagination query: page {}, pageSize {}, name {}, gender {}, begin {}, end {}",
//                page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.pagination(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result pagination(@ModelAttribute EmpQueryParam empQueryParam) {
        log.info("Employee Pagination query param: {} ", empQueryParam);
        PageResult<Emp> pageResult = empService.pagination(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("Employee Add emp: {} ", emp);
        empService.addEmp(emp);
        return Result.success();
    }
}
