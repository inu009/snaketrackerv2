package com.psteide.snaketrackerapiv2.model;

import com.psteide.snaketrackerapiv2.model.dto.FeedingOverrideDto;
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
        private Boolean sizeOverride;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String mealSize;
        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private Boolean frequencyOverride;
        @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
        private String frequency;
        @OneToOne
        @JoinColumn(name = "snake_id")
        private Snake snake;

        public FeedingOverride(){
                this.sizeOverride = false;
                this.mealSize = null;
                this.frequencyOverride = false;
                this.frequency = null;
        }


        public static FeedingOverride from(FeedingOverrideDto feedingOverrideDto){
                FeedingOverride feedingOverride = new FeedingOverride();
                feedingOverride.setId(feedingOverrideDto.getId());
                feedingOverride.setFrequencyOverride(feedingOverrideDto.getSizeOverride());
                feedingOverride.setSizeOverride(feedingOverrideDto.getSizeOverride());
                feedingOverride.setMealSize(feedingOverrideDto.getMealSize());
                feedingOverride.setFrequency(feedingOverrideDto.getFrequency());
                return feedingOverride;
        }
}
