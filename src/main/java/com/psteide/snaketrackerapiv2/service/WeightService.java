package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.WeightRepository;
import com.psteide.snaketrackerapiv2.model.Weight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WeightService {
    private final WeightRepository weightRepository;

    @Autowired
    public WeightService(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    public Weight addWeight(Weight weight){
        return weightRepository.save(weight);
    }

    public List<Weight> getWeights(){
        return StreamSupport
                .stream(weightRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Weight getWeight(Long id){
        return weightRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(id));
    }

    public Weight deleteWeight(Long id){
        Weight weight = getWeight(id);
        weightRepository.delete(weight);
        return weight;
    }

    @Transactional
    public Weight editWeight(Long id, Weight weight){
        Weight weightToEdit = getWeight(id);
        weightToEdit.setDate(weight.getDate());
        weightToEdit.setWeight(weight.getWeight());
        return weightToEdit;

    }
}