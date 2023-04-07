package com.psteide.snaketrackerapiv2.model;

import javax.persistence.*;

import com.psteide.snaketrackerapiv2.model.dto.ShedDto;
import lombok.Data;

@Data
@Entity
@Table(name = "sheds")
public class Shed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String observation;
    @ManyToOne
    private Snake snake;

    public static Shed from(ShedDto shedDto){
        Shed shed = new Shed();
        shed.setDate(shedDto.getDate());
        shed.setObservation(shedDto.getObservation());
        return shed;
    }
}