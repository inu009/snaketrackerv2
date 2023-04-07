package com.psteide.snaketrackerapiv2.controller;

import com.psteide.snaketrackerapiv2.model.Shed;
import com.psteide.snaketrackerapiv2.model.dto.ShedDto;
import com.psteide.snaketrackerapiv2.service.ShedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/sheds")
public class ShedController {

    private final ShedService shedService;
    @Autowired
    public ShedController(ShedService shedService) {
        this.shedService = shedService;
    }

    @PostMapping
    public ResponseEntity<ShedDto> addShed(@RequestBody final ShedDto shedDto){
        Shed shed = shedService.addShed(Shed.from(shedDto));
        return new ResponseEntity<>(ShedDto.from(shed), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShedDto>> getSheds(){
        List<Shed> sheds = shedService.getSheds();
        List<ShedDto> shedsDto = sheds.stream().map(ShedDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(shedsDto, HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<ShedDto> getShed(@PathVariable final Long id){
        Shed shed = shedService.getShed(id);
        return new ResponseEntity<>(ShedDto.from(shed), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<ShedDto> deleteShed(@PathVariable final Long id){
        Shed shed = shedService.deleteShed(id);
        return new ResponseEntity<>(ShedDto.from(shed), HttpStatus.OK);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<ShedDto> editShed(@PathVariable final Long id,
                                                @RequestBody final ShedDto shedDto){
        Shed editedShed = shedService.editShed(id, Shed.from(shedDto));
        return new ResponseEntity<>(ShedDto.from(editedShed), HttpStatus.OK);
    }
}
