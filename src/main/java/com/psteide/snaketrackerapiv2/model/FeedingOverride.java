package com.psteide.snaketrackerapiv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feeding_override")
public class FeedingOverride {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private Boolean sizeOverride = false;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String mealSize = null;
        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private Boolean frequencyOverride = false;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String frequency = null;

        @OneToOne
        @JsonIgnore
        private Snake snake;

}
