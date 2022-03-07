package com.example.mission3.web;

import com.example.mission3.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@RestController
@RequestMapping("file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;

    public FileController(@Autowired FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<String> uploadFiles(@RequestPart List<MultipartFile> files, HttpServletRequest httpServletRequest) throws IOException {
        logger.info(files.stream().map(MultipartFile::getOriginalFilename).collect(Collectors.joining(" ")));

        String path = httpServletRequest.getRequestURL().toString();
        return this.fileService.filesToFilesPathWithStore(files, path);
    }

    @GetMapping(value = "{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] viewImage(@PathVariable("fileName") String fileName) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/static/image/" + fileName);

        return inputStream.readAllBytes();
    }
}
 