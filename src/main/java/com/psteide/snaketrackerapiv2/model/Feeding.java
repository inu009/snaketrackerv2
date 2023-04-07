package com.psteide.snaketrackerapiv2.model;

import javax.persistence.*;

import com.psteide.snaketrackerapiv2.model.dto.FeedingDto;
import lombok.Data;

@Data
@Entity
@Table(name = "feedings")
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String item;
    @ManyToOne
    private Snake snake;

    public static Feeding from(FeedingDto feedingDto){
        Feeding feeding = new Feeding();
        feeding.setDate(feedingDto.getDate());
        feeding.setItem(feedingDto.getItem());
        return feeding;
    }
}
