package pe.example.mybatis.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.example.mybatis.dto.BoardDto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author D0Loop
 * @since 2022-02-26 [2022.2월.26]
 */

@SpringBootTest
class BoardDaoTest {

    @Autowired
    BoardDao boardDao;

    @Test
    void createBoard() {
        BoardDto boardDto = BoardDto.builder()
                .name("new board3").build();

        this.boardDao.createBoard(boardDto);

        BoardDto expected = this.boardDao.readBoard(boardDto.getId());

        assertThat(boardDto).isEqualTo(expected);
    }
}