package com.psteide.snaketrackerapiv2.controller;

import com.psteide.snaketrackerapiv2.model.Snake;
import com.psteide.snaketrackerapiv2.model.dto.SnakeDto;
import com.psteide.snaketrackerapiv2.service.SnakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/snakes")
public class SnakeController {
    private final SnakeService snakeService;

    @Autowired
    public SnakeController(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @PostMapping
    public ResponseEntity<SnakeDto> addSnake(@RequestBody final SnakeDto snakeDto){
        Snake snake = snakeService.addSnake(Snake.from(snakeDto));
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SnakeDto>> getSnakes(){
        List<Snake> snakes = snakeService.getSnakes();
        List<SnakeDto> snakesDto = snakes.stream().map(SnakeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(snakesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<SnakeDto> getSnake(@PathVariable final Long id){
        Snake snake = snakeService.getSnake(id);
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<SnakeDto> deleteSnake(@PathVariable final Long id){
        Snake snake = snakeService.deleteSnake(id);
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<SnakeDto> editSnake(@PathVariable final Long id,
                                              @RequestBody final SnakeDto snakeDto){
        Snake snake = snakeService.editSnake(id, Snake.from(snakeDto));
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }

    @PostMapping(value = "{snakeId}/feedings/{feedingId}/add")
    public ResponseEntity<SnakeDto> addFeedingToSnake(@PathVariable final Long snakeId,
                                                      @PathVariable final Long feedingId){
        Snake snake = snakeService.addFeedingToSnake(snakeId, feedingId);
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }

    @DeleteMapping(value = "{snakeId}/feedings/{feedingId}/remove")
    public ResponseEntity<SnakeDto> removeFeedingFromSnake(@PathVariable final Long snakeId,
                                                      @PathVariable final Long feedingId){
        Snake snake = snakeService.removeFeedingFromSnake(snakeId, feedingId);
        return new ResponseEntity<>(SnakeDto.from(snake), HttpStatus.OK);
    }
}
