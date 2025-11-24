package com.tlias.controller;

import com.tlias.pojo.LoginInfo;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginInfo loginInfo){
        log.info("Login info: {}",loginInfo);
        LoginInfo loginResult = empService.login(loginInfo);
        if(loginResult != null){
            return Result.success();
        }
        return Result.error("用户名或密码错误");
    }
}
