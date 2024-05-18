package com.coderscampus.assignment6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelReport {

    private final String modelVersion;
    private final Map<Integer, Integer> yearlySales;
    private final LocalDate bestMonth;
    private final LocalDate worstMonth;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM-yy");


    ModelReport(String modelVersion, String fileName) {

        //gets file data from file name and filters it
        FileService fileService = new FileService(fileName);
        DataFilter dataFilter = new DataFilter(fileService.readFile());

        //assigns filtered data
        this.modelVersion = modelVersion;
        this.yearlySales = dataFilter.getYearlySales();
        this.bestMonth = dataFilter.getBestMonth();
        this.worstMonth = dataFilter.getWorstMonth();

        //outputs data
        fileService.writeToFile("Model" + modelVersion + "Report", toString());
    }

    public String toString() {

        //header
        String output = "Model " + modelVersion + " Yearly Sales Report\n---------------------------\n";

        //yearly sales data
        output += yearlySales.entrySet()
                             .stream()
                             .map(entry -> entry.getKey() + " -> " + entry.getValue())
                             .collect(Collectors.joining("\n"));

        //month data
        output += "\n\nThe best month for Model " + modelVersion + " was: " + bestMonth.format(dateTimeFormatter)
                + "\nThe worst month for Model " + modelVersion + " was: " + worstMonth.format(dateTimeFormatter);

        return output;
    }
}
