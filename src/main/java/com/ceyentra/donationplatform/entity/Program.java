package com.ceyentra.donationplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "charity_banner")
    private String charityBanner;

    @Column(name = "share_url_banner")
    private String shareUrlBanner;

    public Program() {
    }

    public Program(String charityBanner) {
        this.charityBanner = charityBanner;
    }

    public Program(String charityBanner, String shareUrlBanner) {
        this.charityBanner = charityBanner;
        this.shareUrlBanner = shareUrlBanner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharityBanner() {
        return charityBanner;
    }

    public void setCharityBanner(String charityBanner) {
        this.charityBanner = charityBanner;
    }

    public String getShareUrlBanner() {
        return shareUrlBanner;
    }

    public void setShareUrlBanner(String shareUrlBanner) {
        this.shareUrlBanner = shareUrlBanner;
    }
}
