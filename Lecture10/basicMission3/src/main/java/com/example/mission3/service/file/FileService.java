package com.example.mission3.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public interface FileService {
    List<String> filesToFilesPathWithStore(List<MultipartFile> files, String path) throws IOException;
}
