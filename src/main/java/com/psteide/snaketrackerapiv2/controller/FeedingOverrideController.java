package com.psteide.snaketrackerapiv2.controller;

import com.psteide.snaketrackerapiv2.model.FeedingOverride;
import com.psteide.snaketrackerapiv2.service.FeedingOverrideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/feedingOverride")
public class FeedingOverrideController {
    @Autowired
    private FeedingOverrideService  feedingOverrideService;

    @GetMapping
    public ResponseEntity<List<FeedingOverride>> getAllFeedingOverrides(){
        List<FeedingOverride> feedingOverrides = feedingOverrideService.getAllFeedingOverrides();
        return new ResponseEntity<>(feedingOverrides, HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<FeedingOverride> getFeedingOverrideById(@PathVariable final Long id){
        FeedingOverride feedingOverride = feedingOverrideService.getFeedingOverride(id);
        return new ResponseEntity<>(feedingOverride, HttpStatus.OK);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<FeedingOverride> editFeedingOverride(@PathVariable final Long id,
                                                               @RequestBody final FeedingOverride feedingOverride){
        FeedingOverride editedFeedingOverride = feedingOverrideService.editFeedingOverride(id, feedingOverride);
        return new ResponseEntity<>(editedFeedingOverride, HttpStatus.OK);

    }

}
