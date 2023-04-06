package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.FeedingRepository;
import com.psteide.snaketrackerapiv2.model.Feeding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FeedingService {
    private final FeedingRepository feedingRepository;

    @Autowired
    public FeedingService(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    public Feeding addFeeding(Feeding feeding){
        return feedingRepository.save(feeding);
    }

    public List<Feeding> getFeedings(){
        return StreamSupport
                .stream(feedingRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Feeding getFeeding(Long id){
        return feedingRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(id));
    }

    public Feeding deleteFeeding(Long id){
        Feeding feeding = getFeeding(id);
        feedingRepository.delete(feeding);
        return feeding;
    }

    @Transactional
    public Feeding editFeeding(Long id, Feeding feeding){
        Feeding feedingToEdit = getFeeding(id);
        feedingToEdit.setDate(feeding.getDate());
        feedingToEdit.setItem(feeding.getItem());
        return feedingToEdit;

    }
}
