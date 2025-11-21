package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    /**
     * Handles file upload requests. Saves the uploaded file to the local disk with a unique name.
     *
     * @param file the file being uploaded
     * @return a result object indicating success
     * @throws IOException if an I/O error occurs during file upload
     */
//    @PostMapping("/upload")
//    public Result upload(MultipartFile file) throws IOException {
//        log.info("File upload: {}", file.getOriginalFilename());
//        // get the original filename
//        String originalFilename = file.getOriginalFilename();
//        // generate unique filename using UUID.randomUUID()
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String newFilename = UUID.randomUUID() + extension;
//        // save file to local disk
//        file.transferTo(new File("D:/images/" + newFilename));
//        return Result.success();
//    }

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /**
     * Handles the uploading of a file by storing it in Aliyun OSS and returning the public URL.
     *
     * @param file the file to be uploaded
     * @return a Result object containing the URL of the uploaded file on successful upload
     * @throws Exception if an error occurs during file upload or communication with Aliyun OSS
     */
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("File upload: {}", file.getOriginalFilename());
        // upload file to Aliyun oss
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("File upload success, url: {}", url);
        return Result.success(url);
    }
}
