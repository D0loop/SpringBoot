package com.example.mission3.service.post;

import com.example.mission3.web.dto.PostDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readPostAll(int boardId);
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);
    String fileUpload(MultipartFile files) throws IOException;

}
