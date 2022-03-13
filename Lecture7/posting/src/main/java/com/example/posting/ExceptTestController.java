package com.example.posting;

import com.example.posting.exception.BaseException;
import com.example.posting.exception.ErrorResponseDto;
import com.example.posting.exception.PostNotInBoardException;
import com.example.posting.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

@RestController
@RequestMapping("except")
public class ExceptTestController {

    @GetMapping("{id}")
    public void throwException(@PathVariable int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2 :
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDto handleBaseException(BaseException exception
////            , HttpServletResponse response
//    ) {
//        return new ErrorResponseDto(exception.getMessage());
//    }

}
