package com.psteide.snaketrackerapiv2.repository;

import com.psteide.snaketrackerapiv2.model.Feeding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRepository extends CrudRepository<Feeding, Long> {
}
