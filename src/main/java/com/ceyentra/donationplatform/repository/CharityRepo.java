package com.ceyentra.donationplatform.repository;

import com.ceyentra.donationplatform.entity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharityRepo extends JpaRepository<Charity, String> {

//    @Query(value = "SELECT c.charity_logo FROM charity c WHERE c.charity_logo != '' LIMIT 5 ", nativeQuery = true)
    @Query(value = "SELECT c.charity_logo FROM charity c WHERE c.charity_logo > '' ", nativeQuery = true)
    List<String> getAllCharityLogos();

}
