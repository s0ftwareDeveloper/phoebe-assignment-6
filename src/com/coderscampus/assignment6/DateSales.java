package com.coderscampus.assignment6;

import java.time.LocalDate;

public class DateSales {

    LocalDate date;
    Integer numSales;

    DateSales(LocalDate date, Integer numSales) {
        this.date = date;
        this.numSales = numSales;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNumSales() {
        return numSales;
    }

    public void setNumSales(Integer numSales) {
        this.numSales = numSales;
    }
}
