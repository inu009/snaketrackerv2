package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Feeding;
import lombok.Data;

import java.util.Objects;

@Data
public class FeedingDto {
    private Long id;
    private String date;
    private String item;
    private PlainSnakeDto plainSnakeDto;

    public static FeedingDto from(Feeding feeding){
        FeedingDto feedingDto = new FeedingDto();
        feedingDto.setId(feedingDto.getId());
        feedingDto.setDate(feedingDto.getDate());
        feedingDto.setItem(feedingDto.getItem());
        if(Objects.nonNull(feeding.getSnake())){
            feedingDto.setPlainSnakeDto(PlainSnakeDto.from(feeding.getSnake()));
        }
        return feedingDto;
    }
}
