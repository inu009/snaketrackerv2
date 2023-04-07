package com.psteide.snaketrackerapiv2.controller;

import com.psteide.snaketrackerapiv2.model.Weight;
import com.psteide.snaketrackerapiv2.model.dto.WeightDto;
import com.psteide.snaketrackerapiv2.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/weights")
public class WeightController {

    private final WeightService weightService;
    @Autowired
    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @PostMapping
    public ResponseEntity<WeightDto> addWeight(@RequestBody final WeightDto weightDto){
        Weight weight = weightService.addWeight(Weight.from(weightDto));
        return new ResponseEntity<>(WeightDto.from(weight), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WeightDto>> getWeights(){
        List<Weight> weights = weightService.getWeights();
        List<WeightDto> weightsDto = weights.stream().map(WeightDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(weightsDto, HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<WeightDto> getWeight(@PathVariable final Long id){
        Weight weight = weightService.getWeight(id);
        return new ResponseEntity<>(WeightDto.from(weight), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<WeightDto> deleteWeight(@PathVariable final Long id){
        Weight weight = weightService.deleteWeight(id);
        return new ResponseEntity<>(WeightDto.from(weight), HttpStatus.OK);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<WeightDto> editWeight(@PathVariable final Long id,
                                                  @RequestBody final WeightDto weightDto){
        Weight editedWeight = weightService.editWeight(id, Weight.from(weightDto));
        return new ResponseEntity<>(WeightDto.from(editedWeight), HttpStatus.OK);
    }
}
