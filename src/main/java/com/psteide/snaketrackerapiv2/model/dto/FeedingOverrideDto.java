package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.FeedingOverride;

import lombok.Data;


@Data
public class FeedingOverrideDto {

    private Long id;

    private Boolean sizeOverride;

    private String mealSize;

    private Boolean frequencyOverride;

    private String frequency;



    //private PlainSnakeDto plainSnakeDto;

    public static FeedingOverrideDto from(FeedingOverride feedingOverride){
        FeedingOverrideDto feedingOverrideDto = new FeedingOverrideDto();
        feedingOverrideDto.setId(feedingOverride.getId());
        feedingOverrideDto.setFrequencyOverride(feedingOverride.getSizeOverride());
        feedingOverrideDto.setSizeOverride(feedingOverride.getSizeOverride());
        feedingOverrideDto.setMealSize(feedingOverride.getMealSize());
        feedingOverrideDto.setFrequency(feedingOverride.getFrequency());
        /*
        if(Objects.nonNull(feeding.getSnake())) {
             feedingDto.setPlainSnakeDto(PlainSnakeDto.from(feeding.getSnake()));
         }
        */
        return feedingOverrideDto;
    }
}