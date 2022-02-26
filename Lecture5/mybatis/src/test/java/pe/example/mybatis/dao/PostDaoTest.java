package pe.example.mybatis.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.example.mybatis.dto.PostDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author D0Loop
 * @since 2022-02-26 [2022.2월.26]
 */

@SpringBootTest
class PostDaoTest {

    @Autowired
    PostDao postDao;

    @Test
    void readPost() {
        PostDto expectedDto = this.postDao.readPost(2);

        PostDto actualDto = new PostDto();
        actualDto.setId(2);
        actualDto.setTitle("From Mybatis");
        actualDto.setContent("Uset Database with Spring boot");
        actualDto.setWriter("By Spring Boot");
        actualDto.setBoardId(1);

        assertThat(expectedDto).isEqualTo(actualDto);
    }

    @Test
    void createPost() {

        PostDto expectedDto = PostDto.builder()
                .id(3)
                .title("From Mybatis create")
                .content("create data with Spring boot")
                .writer("By Spring Boot")
                .boardId(1).build();

        int result = this.postDao.createPost(expectedDto);

        PostDto actualDto = this.postDao.readPost(3);
        expectedDto.setId(3);

        assertThat(result).isEqualTo(1);
        assertThat(expectedDto).isEqualTo(actualDto);
    }


    @Test
    void readPostAll() {
        List<PostDto> expectedDto = this.postDao.readPostAll();

        assertThat(expectedDto.size()).isEqualTo(3);
    }

    @Test
    void updatePost() {

        PostDto expectedDto = PostDto.builder()
                .id(3)
                .title("From Mybatis update")
                .content("update data with Spring boot")
                .writer("By Spring Boot")
                .boardId(1).build();

        int result = this.postDao.updatePost(expectedDto);

        PostDto actualDto = this.postDao.readPost(3);

        assertThat(result).isEqualTo(1);
        assertThat(expectedDto).isEqualTo(actualDto);
    }

    @Test
    void deletePost() {
//        PostDto expectedDto = this.postDao.deletePost(3);
//
//        PostDto actualDto = new PostDto();
//        actualDto.setId(2);
//        actualDto.setTitle("From Mybatis");
//        actualDto.setContent("Uset Database with Spring boot");
//        actualDto.setWriter("By Spring Boot");
//        actualDto.setBoardId(1);
//
//        assertThat(expectedDto).isEqualTo(actualDto);
    }
}