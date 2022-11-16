package com.ceyentra.donationplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charity")
public class Charity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "charity_logo")
    private String charityLogo;

    public Charity() {
    }

    public Charity(String charityLogo) {
        this.charityLogo = charityLogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharityLogo() {
        return charityLogo;
    }

    public void setCharityLogo(String charityLogo) {
        this.charityLogo = charityLogo;
    }

    @Override
    public String toString() {
        return "Charity{" +
                "id=" + id +
                ", charityLogo='" + charityLogo + '\'' +
                '}';
    }
}
