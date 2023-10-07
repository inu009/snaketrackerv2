package com.psteide.snaketrackerapiv2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notes")
public class FeedingOverride {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private Boolean sizeOverride;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String mealSize;
        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private Boolean frequencyOverride;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String date;
        @OneToOne
        private Snake snake;
}
