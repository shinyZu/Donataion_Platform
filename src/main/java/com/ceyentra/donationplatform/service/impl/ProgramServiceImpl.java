package com.ceyentra.donationplatform.service.impl;

import com.ceyentra.donationplatform.repository.ProgramRepo;
import com.ceyentra.donationplatform.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    @Override
    public List<String> getAllCharityBanners() {
            return programRepo.getAllCharityBanners();
    }

    @Override
    public List<String> getAllShareURLBanners() {
        return programRepo.getAllShareURLBanners();
    }
}
