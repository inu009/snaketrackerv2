package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Feeding;
import com.psteide.snaketrackerapiv2.model.FeedingOverride;
import com.psteide.snaketrackerapiv2.model.Snake;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SnakeDto {
    private Long id;
    private String owner;
    private String name;
    private String breederId;
    private String imgUrl;
    private String gender;
    private List<FeedingDto> feedingsDto = new ArrayList<>();

    private List<WeightDto> weightsDto = new ArrayList<>();

    private List<ShedDto> shedsDto = new ArrayList<>();

    private List<NoteDto> notesDto = new ArrayList<>();

    private FeedingOverride feedingOverride;


    public static SnakeDto from(Snake snake){
        SnakeDto snakeDto = new SnakeDto();
        snakeDto.setId(snake.getId());
        snakeDto.setOwner(snake.getOwner());
        snakeDto.setName(snake.getName());
        snakeDto.setBreederId(snake.getBreederId());
        snakeDto.setImgUrl(snake.getImgUrl());
        snakeDto.setGender(snake.getGender());
        snakeDto.setFeedingsDto(snake.getFeedings()
                .stream().map(FeedingDto::from)
                .collect(Collectors.toList()));
        snakeDto.setWeightsDto(snake.getWeights()
                .stream().map(WeightDto::from)
                .collect(Collectors.toList()));
        snakeDto.setShedsDto(snake.getSheds()
                .stream().map(ShedDto::from)
                .collect(Collectors.toList()));
        snakeDto.setNotesDto(snake.getNotes()
                .stream().map(NoteDto::from)
                .collect(Collectors.toList()));
        snakeDto.setFeedingOverride(snake.getFeedingOverride());
        return snakeDto;
    }
}
