package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * find all departments
     * @return dept list
     */
    List<Dept> findAll();

    /**
     * delete department by id
     * @param id department id
     */
    void deleteById(Integer id);

    /**
     * add department
     * @param dept department object
     */
    void add(Dept dept);

    /**
     * get department by id
     * @param deptId department id
     */
    Dept getDeptById(Integer deptId);

    /**
     * update department by id
     * @param dept department object
     */
    void updateDeptbyId(Dept dept);
}
