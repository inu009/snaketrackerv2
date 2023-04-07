package com.psteide.snaketrackerapiv2.model;

import com.psteide.snaketrackerapiv2.model.dto.SnakeDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "snakes")
public class Snake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "name")
    private String name;

    @Column(name = "breeder_id")
    private String breederId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "gender")
    private String gender;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "snake_id")
    private List<Feeding> feedings = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "snake_id")
    private List<Weight> weights = new ArrayList<>();


    public void addFeeding (Feeding feeding){
        feedings.add(feeding);
    }

    public void removeFeeding (Feeding feeding){
        feedings.remove(feeding);
    }

    public void addWeight (Weight weight){
        weights.add(weight);
    }

    public void removeWeight (Weight weight){
        weights.remove(weight);
    }

    public static Snake from(SnakeDto snakeDto){
        Snake snake = new Snake();
        snake.setOwner(snakeDto.getOwner());
        snake.setName(snakeDto.getName());
        snake.setBreederId(snakeDto.getBreederId());
        snake.setImgUrl(snakeDto.getImgUrl());
        snake.setGender(snakeDto.getGender());
        return snake;

    }
}