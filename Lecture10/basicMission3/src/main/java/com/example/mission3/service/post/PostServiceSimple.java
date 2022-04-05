package com.example.mission3.service.post;

import com.example.mission3.domain.PostEntity;
import com.example.mission3.service.board.BoardService;
import com.example.mission3.web.dto.PostDto;
import com.example.mission3.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Service
@RequiredArgsConstructor
public class PostServiceSimple implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);

    private final PostRepository postRepository;

    private final BoardService boardService;

    @Override
    public void createPost(PostDto dto) {
        this.postRepository.save(dto.toEntity());
    }

    @Override
    public List<PostDto> readPostAll(int boardId) {
        List<PostEntity> postEntityList = boardService.readPostAtBoard(boardId);

        return postEntityList.stream().map(PostDto::new).collect(Collectors.toList());
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById((long) id)
                .map(PostDto::new)
                .orElseThrow(() -> new IllegalArgumentException("No post has id = " + id));
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        PostEntity targetEntity = this.postRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        targetEntity.setTitle(dto.getTitle() == null ? targetEntity.getTitle() : dto.getTitle());
        targetEntity.setContent(dto.getContent() == null ? targetEntity.getContent() : dto.getContent());

        this.postRepository.save(targetEntity);
    }

    @Override
    public void deletePost(int id) {

        PostEntity targetEntity = this.postRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("No post has id = " + id));

        this.postRepository.delete(targetEntity);
    }


    @Override
    public String fileUpload(MultipartFile file) throws IOException {
//        return FileUploadUtil.filesToFileNamesWithStore(file);
        return "";
    }
}
