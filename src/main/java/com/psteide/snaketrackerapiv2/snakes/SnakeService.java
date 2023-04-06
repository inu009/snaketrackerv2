package com.psteide.snaketrackerapiv2.snakes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnakeService {
    @Autowired
    private SnakeRepository snakeRepository;

    public Iterable<Snake> list() {
        return snakeRepository.findAll();
    }

    public Optional<Snake> findById(Long id) {
        return snakeRepository.findById(id);
    }

    public Snake create(Snake snake) {
        return snakeRepository.save(snake);
    }

    public Optional<Snake> update(Snake snake) {
        Optional<Snake> foundSnake = snakeRepository.findById(snake.getId());

        if (foundSnake.isPresent()) {
            Snake updatedSnake = foundSnake.get();
            updatedSnake.setOwner(snake.getOwner());
            updatedSnake.setName(snake.getName());
            updatedSnake.setBreederId(snake.getBreederId());
            updatedSnake.setImgUrl(snake.getImgUrl());
            updatedSnake.setGender(snake.getGender());
            snakeRepository.save(updatedSnake);
            return Optional.of(updatedSnake);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        snakeRepository.deleteById(id);
    }
}

