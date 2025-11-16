package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * find all departments
     * @return dept list
     */
    @GetMapping
    public Result list() {
        log.info("find all departments");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * delete department by id
     * @param deptId department id
     * @return result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer deptId) {
        log.info("delete department by id: {}", deptId);
        deptService.deleteById(deptId);
        return Result.success();
    }

    /**
     * add department
     * @param dept department object
     * @return result
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("add department: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * get department by id
     * @param deptId department id
     * @return result
     */
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable("id") Integer deptId) {
        log.info("get department by id: {}", deptId);
        Dept dept = deptService.getDeptById(deptId);
        return Result.success(dept);
    }

    /**
     * update department by id
     * @param dept department object
     * @return result
     */
    @PutMapping
    public Result updateDeptbyId(@RequestBody Dept dept){
        log.info("update department by id: {}", dept);
        deptService.updateDeptbyId(dept);
        return Result.success();
    }
}
