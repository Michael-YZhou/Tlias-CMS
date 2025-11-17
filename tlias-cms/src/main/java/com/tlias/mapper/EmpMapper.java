package com.tlias.mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * Counts the total number of employees by performing a left join between the emp table
     * and the dept table based on the department ID.
     * Apply LIMIT with range for pagination.
     * @return the total count of employees as a Long value
     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    Long countEmp();
//
//    @Select("""
//        SELECT e.id,
//               e.name,
//               e.create_time,
//               e.update_time,
//               e.job,
//               e.image,
//               e.dept_id,
//               e.entry_date AS entryDate,
//               d.name AS deptName
//        FROM emp e
//        LEFT JOIN dept d ON e.dept_id = d.id
//        ORDER BY e.update_time DESC
//        LIMIT #{start}, #{pageSize}
//        """)
//    List<Emp> findPageEmp(Integer start, Integer pageSize);

    /**
     * Select all rows for pagination.
     * No need to apply LIMIT because we use pageHelper in this case.
     * @return list of employees
     */
    @Select("""
        SELECT e.id,
               e.name,
               e.create_time,
               e.update_time,
               e.job,
               e.image,
               e.dept_id,
               e.entry_date AS entryDate,
               d.name AS deptName
        FROM emp e
        LEFT JOIN dept d ON e.dept_id = d.id
        ORDER BY e.update_time DESC
        """)
    List<Emp> list();


}
