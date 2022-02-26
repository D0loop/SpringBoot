package pe.example.mybatis.mapper;

import pe.example.mybatis.dto.PostDto;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-24 [2022.2월.24]
 */

public interface PostMapper {
    int createPost(PostDto postDto);
    int createPostAll(List<PostDto> postDtos);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto postDto);
    int updatePost(PostDto postDto);
    int deletePost(int id);
}
