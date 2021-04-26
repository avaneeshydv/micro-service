package com.ava.user.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public boolean uploadFile(MultipartFile multipartFile) {
        try {
            String loc = new ClassPathResource("static/image").getFile().getAbsolutePath() + File.separator
                            + multipartFile.getOriginalFilename();
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(loc),
                    StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

}
