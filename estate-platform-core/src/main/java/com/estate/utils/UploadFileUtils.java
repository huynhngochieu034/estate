package com.estate.utils;

import com.estate.constant.SystemConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadFileUtils {



    public static void writeOrUpdate(String path, byte[] bytes) {
        path = SystemConstant.HOME_BUILDING + path;
       /* File file = new File(StringUtils.substringBeforeLast(path, "/"));
        if (!file.exists()) {
            file.mkdir();
        }*/
        try(FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
