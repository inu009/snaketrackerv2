package com.psteide.snaketrackerapiv2.snakes;

import lombok.Data;
import javax.persistence.*;

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
}
