package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Weight;
import lombok.Data;

import java.util.Objects;

@Data
public class WeightDto {
    private Long id;
    private String date;
    private Integer weight;
    //private PlainSnakeDto plainSnakeDto;

    public static WeightDto from(Weight weight){
        WeightDto weightDto = new WeightDto();
        weightDto.setId(weight.getId());
        weightDto.setDate(weight.getDate());
        weightDto.setWeight(weight.getWeight());
        //if(Objects.nonNull(feeding.getSnake())){
        //  feedingDto.setPlainSnakeDto(PlainSnakeDto.from(feeding.getSnake()));
        //}
        return weightDto;
    }
}