package com.psteide.snaketrackerapiv2.repository;

import com.psteide.snaketrackerapiv2.model.Snake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnakeRepository extends CrudRepository<Snake, Long> {
}
