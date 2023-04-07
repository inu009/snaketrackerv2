package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Shed;
import lombok.Data;

import java.util.Objects;

@Data
public class ShedDto {
    private Long id;
    private String date;
    private String observation;
    //private PlainSnakeDto plainSnakeDto;

    public static ShedDto from(Shed shed){
        ShedDto shedDto = new ShedDto();
        shedDto.setId(shed.getId());
        shedDto.setDate(shed.getDate());
        shedDto.setObservation(shed.getObservation());
        //if(Objects.nonNull(shed.getSnake())){
        //  shedDto.setPlainSnakeDto(PlainSnakeDto.from(shed.getSnake()));
        //}
        return shedDto;
    }
}