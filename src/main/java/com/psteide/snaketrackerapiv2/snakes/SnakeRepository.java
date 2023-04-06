package com.psteide.snaketrackerapiv2.snakes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnakeRepository extends CrudRepository<Snake, Long> {}
