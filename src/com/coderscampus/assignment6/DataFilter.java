package com.coderscampus.assignment6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataFilter {

    List<DateSales> data;

    DataFilter(List<DateSales> data) {
        this.data = data;
    }

    public void getBestYear() {
        Map<Integer, List<DateSales>> groupedData = data.stream()
                                                        .collect(Collectors.groupingBy(entry -> entry.getDate()
                                                                                                     .getMonthValue()));
        groupedData.entrySet()
                   .stream()
                   .forEach(group -> System.out.println(group.getValue()));
    }
}
