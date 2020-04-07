package com.ph.monitorPlatform.conf;

import com.ph.monitorPlatform.service.impl.UploadServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;

@Configuration
@ConditionalOnMissingBean(UploadServiceImpl.class)
public class FileSystemConfig {

    @Autowired
    Environment env;

    @Bean
    public UploadServiceImpl getFileService() {
        //获取属性配制文件中的值
        String root = env.getProperty("localFile.root");
        if (StringUtils.isEmpty(root)) {
            String system = System.getProperty("os.name");
            //判断系统
            if (system.toLowerCase().contains("win")) {
                String userDir = System.getProperty("user.dir");
                root = userDir + File.separator + "filesystem";
            } else {
                String userHome = System.getProperty("user.home");
                root = userHome + File.separator + "filesystem";
            }
        }
        File f = new File(root);
        if (!f.exists()) {
            f.mkdirs();
        }
        return new UploadServiceImpl(root);
    }

}
