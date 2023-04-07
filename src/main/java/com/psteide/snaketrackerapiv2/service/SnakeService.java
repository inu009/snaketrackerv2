package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.*;
import com.psteide.snaketrackerapiv2.model.exception.*;
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
    private final WeightService weightService;
    private final ShedService shedService;
    private final NoteService noteService;

    @Autowired
    public SnakeService(SnakeRepository snakeRepository,
                        FeedingService feedingService,
                        WeightService weightService,
                        ShedService shedService,
                        NoteService noteService) {
        this.snakeRepository = snakeRepository;
        this.feedingService = feedingService;
        this.weightService = weightService;
        this.shedService = shedService;
        this.noteService = noteService;
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

    @Transactional
    public Snake addWeightToSnake(Long snakeId, Long weightId){
        Snake snake = getSnake(snakeId);
        Weight weight = weightService.getWeight(weightId);
        if(Objects.nonNull(weight.getSnake())){
            throw new WeightAlreadyAssignedException(weightId,
                    weight.getSnake().getId());
        }
        snake.addWeight(weight);
        return snake;
    }

    @Transactional
    public Snake removeWeightFromSnake(Long snakeId, Long weightId){
        Snake snake = getSnake(snakeId);
        Weight weight = weightService.getWeight(weightId);
        snake.removeWeight(weight);
        return snake;
    }

    @Transactional
    public Snake addShedToSnake(Long snakeId, Long shedId){
        Snake snake = getSnake(snakeId);
        Shed shed = shedService.getShed(shedId);
        if(Objects.nonNull(shed.getSnake())){
            throw new ShedAlreadyAssignedException(shedId,
                    shed.getSnake().getId());
        }
        snake.addShed(shed);
        return snake;
    }

    @Transactional
    public Snake removeShedFromSnake(Long snakeId, Long shedId){
        Snake snake = getSnake(snakeId);
        Shed shed = shedService.getShed(shedId);
        snake.removeShed(shed);
        return snake;
    }

    @Transactional
    public Snake addNoteToSnake(Long snakeId, Long noteId){
        Snake snake = getSnake(snakeId);
        Note note = noteService.getNote(noteId);
        if(Objects.nonNull(note.getSnake())){
            throw new NoteAlreadyAssignedException(noteId,
                    note.getSnake().getId());
        }
        snake.addNote(note);
        return snake;
    }

    @Transactional
    public Snake removeNoteFromSnake(Long snakeId, Long noteId){
        Snake snake = getSnake(snakeId);
        Note note = noteService.getNote(noteId);
        snake.removeNote(note);
        return snake;
    }


}
