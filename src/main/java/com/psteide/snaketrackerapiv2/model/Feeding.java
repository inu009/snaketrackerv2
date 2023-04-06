package com.psteide.snaketrackerapiv2.model;

import javax.persistence.*;

import com.psteide.snaketrackerapiv2.model.dto.FeedingDto;
import lombok.Data;

@Entity
@Data
@Table(name = "feedings")
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "item")
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
