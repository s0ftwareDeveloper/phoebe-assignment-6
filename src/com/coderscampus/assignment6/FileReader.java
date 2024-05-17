package com.coderscampus.assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    public List<DateSales> readFile(String file) {
        List<DateSales> dateSalesList = new ArrayList<>();

        //reads file and adds info to the list
        try (Stream<String> lines = Files.lines(Path.of(file))) {
            //skips over the header line
            lines.skip(1)
                 .map(line -> line.split(","))
                 .forEach(args -> dateSalesList.add(parseDateSales(args[0], args[1])));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dateSalesList;
    }

    private DateSales parseDateSales(String date, String sales) {

//        added + "-01" because LocalDate could not be parsed without day
        LocalDate parsedDate = LocalDate.parse(date + "-01", DateTimeFormatter.ofPattern("MMM-yy-dd"));

        return new DateSales(parsedDate, Integer.parseInt(sales));
    }
}
