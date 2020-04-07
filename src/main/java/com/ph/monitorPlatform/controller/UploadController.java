package com.ph.monitorPlatform.controller;

import com.ph.monitorPlatform.service.UploadService;
import com.ph.monitorPlatform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    @ResponseBody
    public JsonResult<String> uploadImg(@RequestParam(value = "file", required = false) MultipartFile file) {
        if (file == null) {
            return JsonResult.failMessage("上传文件不能为空");
        }
        String path = uploadService.uploadImg(file);
        return JsonResult.successMessage(path);
    }


}
