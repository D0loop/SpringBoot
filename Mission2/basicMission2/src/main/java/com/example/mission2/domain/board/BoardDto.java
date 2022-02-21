package com.example.mission2.domain.board;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public class BoardDto {

    private int id;
    private String name;

    public BoardDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
