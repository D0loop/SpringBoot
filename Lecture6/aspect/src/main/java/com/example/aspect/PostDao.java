package com.example.aspect;

import com.example.aspect.entity.PostEntity;
import com.example.aspect.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

/**
 * @author D0Loop
 * @since 2022-03-01 [2022.3월.01]
 */

@Repository
@RequiredArgsConstructor
public class PostDao {

    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;


    public void createPost(PostDto postDto) {

        PostEntity postEntity = PostEntity.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .writer(postDto.getWriter())
                .boardEntity(null).build();

        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id) {
        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if(postEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll() {
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto postDto) {
//        PostEntity postEntity = postDto.toPostEntity();
//        postEntity.setTitle(postDto.getTitle() == null ? postEntity.get);

        Optional<PostEntity> targetEntity = this.postRepository.findById(Long.valueOf(id));
        if(targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        PostEntity postEntity = targetEntity.get();
        logger.info(postEntity.toString());

        postEntity.setTitle(postDto.getTitle() == null ? postEntity.getTitle() : postDto.getTitle());
        postEntity.setContent(postDto.getContent() == null ? postEntity.getContent() : postDto.getContent());

        logger.info(postEntity.toString());

        this.postRepository.save(postEntity);
    }

    public void deletePost(int id) {

        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }
}
