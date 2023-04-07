package com.psteide.snaketrackerapiv2.controller;

import com.psteide.snaketrackerapiv2.model.Feeding;
import com.psteide.snaketrackerapiv2.model.dto.FeedingDto;
import com.psteide.snaketrackerapiv2.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/feedings")
public class FeedingController {

    private final FeedingService feedingService;
   @Autowired
    public FeedingController(FeedingService feedingService) {
       this.feedingService = feedingService;
    }

    @PostMapping
    public ResponseEntity<FeedingDto> addFeeding(@RequestBody final FeedingDto feedingDto){
            Feeding feeding = feedingService.addFeeding(Feeding.from(feedingDto));
            return new ResponseEntity<>(FeedingDto.from(feeding), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FeedingDto>> getFeedings(){
        List<Feeding> feedings = feedingService.getFeedings();
        List<FeedingDto> feedingsDto = feedings.stream().map(FeedingDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(feedingsDto, HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<FeedingDto> getFeeding(@PathVariable final Long id){
        Feeding feeding = feedingService.getFeeding(id);
        return new ResponseEntity<>(FeedingDto.from(feeding), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<FeedingDto> deleteFeeding(@PathVariable final Long id){
        Feeding feeding = feedingService.deleteFeeding(id);
        return new ResponseEntity<>(FeedingDto.from(feeding), HttpStatus.OK);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<FeedingDto> editFeeding(@PathVariable final Long id,
                                                  @RequestBody final FeedingDto feedingDto){
        Feeding editedFeeding = feedingService.editFeeding(id, Feeding.from(feedingDto));
        return new ResponseEntity<>(FeedingDto.from(editedFeeding), HttpStatus.OK);
    }
}
