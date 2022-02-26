package pe.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.example.mybatis.dao.PostDao;
import pe.example.mybatis.dto.PostDto;


/**
 * @author D0Loop
 * @since 2022-02-26 [2022.2월.26]
 */

@Component
public class TestComponent {

    private final PostDao postDao;
    public TestComponent(@Autowired PostDao postDao) {
        this.postDao = postDao;

//        PostDto newPost = new PostDto();
//        newPost.setTitle("From Mybatis");
//        newPost.setContent("Uset Database with Spring boot");
//        newPost.setWriter("By Spring Boot");
//        newPost.setBoardId(1);
//        this.postDao.createPost(newPost);

    }
}
