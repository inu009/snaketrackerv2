package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.ShedRepository;
import com.psteide.snaketrackerapiv2.model.Shed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShedService {
    private final ShedRepository shedRepository;

    @Autowired
    public ShedService(ShedRepository shedRepository) {
        this.shedRepository = shedRepository;
    }

    public Shed addShed(Shed shed) {
        return shedRepository.save(shed);
    }

    public List<Shed> getSheds() {
        return StreamSupport
                .stream(shedRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Shed getShed(Long id) {
        return shedRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public Shed deleteShed(Long id) {
        Shed shed = getShed(id);
        shedRepository.delete(shed);
        return shed;
    }

    @Transactional
    public Shed editShed(Long id, Shed shed) {
        Shed shedToEdit = getShed(id);
        shedToEdit.setDate(shed.getDate());
        shedToEdit.setObservation(shed.getObservation());
        return shedToEdit;
    }
}

    