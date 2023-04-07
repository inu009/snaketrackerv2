package com.psteide.snaketrackerapiv2.repository;

import com.psteide.snaketrackerapiv2.model.Weight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long> {
}
