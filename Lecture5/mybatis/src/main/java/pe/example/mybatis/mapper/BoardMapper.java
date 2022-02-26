package pe.example.mybatis.mapper;

import org.springframework.stereotype.Repository;
import pe.example.mybatis.dto.BoardDto;

/**
 * @author D0Loop
 * @since 2022-02-24 [2022.2월.24]
 */

public interface BoardMapper {
    int createBoard(BoardDto dto);
    BoardDto readBoard(int id);
}
