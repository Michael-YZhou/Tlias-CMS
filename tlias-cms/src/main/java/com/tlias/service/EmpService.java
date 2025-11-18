package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> pagination(EmpQueryParam empQueryParam);
}
