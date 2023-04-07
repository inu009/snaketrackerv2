package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.Feeding;
import com.psteide.snaketrackerapiv2.model.Snake;
import com.psteide.snaketrackerapiv2.model.exception.FeedingAlreadyAssignedException;
import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.SnakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SnakeService {

    private final SnakeRepository snakeRepository;
    private final FeedingService feedingService;

    @Autowired
    public SnakeService(SnakeRepository snakeRepository, FeedingService feedingService) {
        this.snakeRepository = snakeRepository;
        this.feedingService = feedingService;
    }

    public Snake addSnake(Snake snake){
        return snakeRepository.save(snake);
    }

    public List<Snake> getSnakes(){
        return StreamSupport
                .stream(snakeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Snake getSnake(Long id){
        return snakeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    public Snake deleteSnake(Long id){
        Snake snake = getSnake(id);
       snakeRepository.delete(snake);
       return snake;
    }

    @Transactional
    public Snake editSnake(Long id, Snake snake){
        Snake snakeToEdit = getSnake(id);
        snakeToEdit.setOwner(snake.getOwner());
        snakeToEdit.setName(snake.getName());
        snakeToEdit.setBreederId(snake.getBreederId());
        snakeToEdit.setImgUrl(snake.getImgUrl());
        snakeToEdit.setGender(snake.getGender());
        return snakeToEdit;
    }

    @Transactional
    public Snake addFeedingToSnake(Long snakeId, Long feedingId){
        Snake snake = getSnake(snakeId);
        Feeding feeding = feedingService.getFeeding(feedingId);
        if(Objects.nonNull(feeding.getSnake())){
            throw new FeedingAlreadyAssignedException(feedingId,
                    feeding.getSnake().getId());
        }
        snake.addFeeding(feeding);
        return snake;
    }
    @Transactional
    public Snake removeFeedingFromSnake(Long snakeId, Long feedingId){
        Snake snake = getSnake(snakeId);
        Feeding feeding = feedingService.getFeeding(feedingId);
        snake.removeFeeding(feeding);
        return snake;
    }
}