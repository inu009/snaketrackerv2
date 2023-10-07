package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.FeedingOverride;
import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.FeedingOverrideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FeedingOverrideService {
    @Autowired
    private FeedingOverrideRepository feedingOverrideRepository;


    public FeedingOverride getFeedingOverride(Long id){
        return feedingOverrideRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(id));
    }

    public List<FeedingOverride> getAllFeedingOverrides(){
        return StreamSupport
                .stream(feedingOverrideRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    @Transactional
    public FeedingOverride editFeedingOverride(Long id, FeedingOverride feedingOverride){
        FeedingOverride feedingOverrideToEdit = getFeedingOverride(id);
        feedingOverrideToEdit.setFrequencyOverride(feedingOverride.getSizeOverride());
        feedingOverrideToEdit.setSizeOverride(feedingOverride.getSizeOverride());
        feedingOverrideToEdit.setMealSize(feedingOverride.getMealSize());
        feedingOverrideToEdit.setDate(feedingOverride.getDate());
        return feedingOverrideToEdit;
    }

}
