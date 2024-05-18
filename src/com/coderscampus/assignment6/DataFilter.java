package com.coderscampus.assignment6;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataFilter {

    List<DateSales> data;

    DataFilter(List<DateSales> data) {
        this.data = data;
    }

    public Map<Integer, Integer> getYearlySales() {

        //groups data by year and sums number of sales for each year
        return data.stream()
                   .collect(Collectors.groupingBy(entry -> entry.getDate()
                                                                .getYear(), Collectors.summingInt(DateSales::getNumSales)));
    }

    public LocalDate getBestMonth() {

        return data.stream()
                   // compares sales data and gets the max
                   .max(Comparator.comparing(DateSales::getNumSales))
                   // gets date
                   .map(DateSales::getDate)
                   .orElse(null);
    }

    public LocalDate getWorstMonth() {

        return data.stream()
                   // compares sales data and gets the min
                   .min(Comparator.comparing(DateSales::getNumSales))
                   // gets date
                   .map(DateSales::getDate)
                   .orElse(null);
    }
}
