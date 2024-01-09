package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;

public class CompensationServiceImpl implements CompensationService {

    @Autowired
    CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation) {

        compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public Compensation read(String id) {

        Compensation compensation = compensationRepository.findByEmployeeEmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Cannot find salary data for employee with id " + id);
        }

        return compensation;
    }
}