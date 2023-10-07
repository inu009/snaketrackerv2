package com.psteide.snaketrackerapiv2.repository;


import com.psteide.snaketrackerapiv2.model.FeedingOverride;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingOverrideRepository extends CrudRepository<FeedingOverride, Long>{
}

