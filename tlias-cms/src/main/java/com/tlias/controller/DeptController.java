package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        System.out.println( "find all departments");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println( "delete department by id: " + id);
        deptService.deleteById(id);
        return Result.success();
    }
}
