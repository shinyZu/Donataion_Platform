package com.ceyentra.donationplatform.repository;

import com.ceyentra.donationplatform.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgramRepo extends JpaRepository<Program, String> {

    @Query(value = "SELECT charity_banner FROM program p WHERE p.charity_banner NOT LIKE 'https://mydonate-resources%'", nativeQuery = true)
    List<String> getAllCharityBanners();

    @Query(value = "SELECT share_url_banner FROM program p WHERE p.share_url_banner NOT LIKE 'https://mydonate-resources%'", nativeQuery = true)
    List<String> getAllShareURLBanners();
}
