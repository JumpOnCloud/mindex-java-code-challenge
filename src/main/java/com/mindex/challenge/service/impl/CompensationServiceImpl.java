package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompensationServiceImpl implements CompensationService {

    @Autowired
    CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation) {

        log.info("Received request to create compensation for employee with id [{}]",
                compensation.getEmployee().getEmployeeId());

        compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public Compensation read(String id) {

        log.info("Retrieving compensation data for employee with id [{}]", id);

        Compensation compensation = compensationRepository.findByEmployeeEmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Cannot find salary data for employee with id " + id);
        }

        return compensation;
    }
}