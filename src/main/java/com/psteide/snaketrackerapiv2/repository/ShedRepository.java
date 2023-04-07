package com.psteide.snaketrackerapiv2.repository;

import com.psteide.snaketrackerapiv2.model.Shed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShedRepository extends CrudRepository<Shed, Long> {
}
