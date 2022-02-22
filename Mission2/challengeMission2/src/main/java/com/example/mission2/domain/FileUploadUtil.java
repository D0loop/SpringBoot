package com.example.mission2.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Component
public class FileUploadUtil {

    @Value("${upload.path}")
    private static String FILE_UPLOAD_PATH;

//    public void setFILE_UPLOAD_PATH(String FILE_UPLOAD_PATH) {
//        this.FILE_UPLOAD_PATH = FILE_UPLOAD_PATH;
//    }

    public static String filesToFileNamesWithStore(MultipartFile file) throws IOException {
        filesToStore(file);
        return file.getOriginalFilename();
    }

    private static void filesToStore(MultipartFile file) throws IOException {

        Path path = Paths.get(FILE_UPLOAD_PATH + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        System.out.println(path.toAbsolutePath());
//        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    }
}
