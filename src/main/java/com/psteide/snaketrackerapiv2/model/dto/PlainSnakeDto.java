package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Snake;
import lombok.Data;

@Data
public class PlainSnakeDto {
    private Long id;
    private String owner;
    private String name;
    private String breederId;
    private String imgUrl;
    private String gender;

    public static PlainSnakeDto from(Snake snake){
        PlainSnakeDto plainSnakeDto = new PlainSnakeDto();
        plainSnakeDto.setId(snake.getId());
        plainSnakeDto.setOwner(snake.getOwner());
        plainSnakeDto.setName(snake.getName());
        plainSnakeDto.setBreederId(snake.getBreederId());
        plainSnakeDto.setImgUrl(snake.getImgUrl());
        plainSnakeDto.setGender(snake.getGender());
        return plainSnakeDto;
    }
}
