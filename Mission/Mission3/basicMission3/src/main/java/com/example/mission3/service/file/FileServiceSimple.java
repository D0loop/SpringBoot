package com.example.mission3.service.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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


@Service
public class FileServiceSimple implements FileService {

    @Value("${upload.path}")
    private String FILE_UPLOAD_PATH;

    @Override
    public List<String> filesToFilesPathWithStore(List<MultipartFile> files, String path) throws IOException {
        filesToStore(files);
        return files.stream().map(file -> path + File.separator + file.getOriginalFilename()).collect(Collectors.toList());
    }

    private void filesToStore(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {
            Path path = Paths.get(FILE_UPLOAD_PATH + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
