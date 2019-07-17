package com.cleverlance.academy.airlines.model;

public class Plane {

    private Long id;
    private String registrationCode;
    private Integer economy;
    private Integer firstClass;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(final String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Integer getEconomy() {
        return economy;
    }

    public void setEconomy(final Integer economy) {
        this.economy = economy;
    }

    public Integer getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(final Integer firstClass) {
        this.firstClass = firstClass;
    }
}
