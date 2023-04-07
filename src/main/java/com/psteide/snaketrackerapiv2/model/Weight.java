package com.psteide.snaketrackerapiv2.model;

import javax.persistence.*;

import com.psteide.snaketrackerapiv2.model.dto.WeightDto;
import lombok.Data;

@Data
@Entity
@Table(name = "weights")
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private Integer weight;
    @ManyToOne
    private Snake snake;

    public static Weight from(WeightDto weightDto){
        Weight weight = new Weight();
        weight.setDate(weightDto.getDate());
        weight.setWeight(weightDto.getWeight());
        return weight;
    }
}