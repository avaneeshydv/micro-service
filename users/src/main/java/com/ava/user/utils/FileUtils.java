package com.ava.user.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

    public static boolean validateFile(MultipartFile file) {

        if (StringUtils.equalsIgnoreCase(file.getContentType(), "image/jpeg")
                || StringUtils.equalsIgnoreCase(file.getContentType(), "image/jpg")
                || StringUtils.equalsIgnoreCase(file.getContentType(), "image/png")) {
            return true;
        } else if (file.isEmpty()) {
            return false;
        } else {
            return false;
        }
    }

}