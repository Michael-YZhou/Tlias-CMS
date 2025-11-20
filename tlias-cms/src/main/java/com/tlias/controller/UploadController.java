package com.tlias.controller;

import com.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("File upload name: {}, age: {}, file: {}", name, age, file.getOriginalFilename());
        // get the original filename
        String originalFilename = file.getOriginalFilename();
        // generate unique filename using UUID.randomUUID()
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID() + extension;
        // save file to local disk
        file.transferTo(new File("D:/images/" + newFilename));
        return Result.success();
    }
}
