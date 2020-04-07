package com.ph.monitorPlatform.service.impl;

import com.ph.monitorPlatform.service.UploadService;
import com.ph.monitorPlatform.utils.DateUtil;
import com.ph.monitorPlatform.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
public class UploadServiceImpl implements UploadService {
    String root = null;

    public UploadServiceImpl(String root) {
        this.root = root;
    }

    @Override
    public String uploadImg(MultipartFile uploadFile) {
        String dir = createFilePath();
        String fileNewName = fileNewName(uploadFile.getOriginalFilename());
        String path = dir + File.separator + fileNewName;
        File destFile = new File(path);
        try {
            //保存文件,将uploadFile对象装入destFile文件中
            uploadFile.transferTo(destFile);
        } catch (IOException e) {
            log.error("upload image error : {}", e);
        }
        return path;
    }


    public String createFilePath() {
        //以年月日形式创建文件夹
        String dir = DateUtil.formateNow("yyyyMMdd");
        String path = root + File.separator + dir;
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        return path;
    }

    public String fileNewName(String originalFilename) {
        String fileNewName = UUIDUtil.createUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        return fileNewName;
    }
}
