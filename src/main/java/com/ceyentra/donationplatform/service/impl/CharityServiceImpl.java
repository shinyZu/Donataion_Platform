package com.ceyentra.donationplatform.service.impl;

import com.ceyentra.donationplatform.repository.CharityRepo;
import com.ceyentra.donationplatform.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    @Autowired
    private CharityRepo charityRepo;

    @Override
    public List<String> getAllCharityLogos() {
        return charityRepo.getAllCharityLogos();
    }
}
