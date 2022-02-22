package com.example.mission2.service.post;

import com.example.mission2.domain.post.PostDto;
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
    boolean updatePost(int id, PostDto dto);
    boolean deletePost(int id, String passwoard);
    String fileUpload(MultipartFile files) throws IOException;

}
