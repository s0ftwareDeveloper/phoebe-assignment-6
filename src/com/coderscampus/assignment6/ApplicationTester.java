package com.coderscampus.assignment6;

import java.util.List;

public class ApplicationTester {

    public static void main(String[] args) {

        final String MODEL_3_PATH = "src/model3.csv";
        final String MODEL_S_PATH = "src/modelS.csv";
        final String MODEL_X_PATH = "src/modelX.csv";

        FileReader fileReader = new FileReader();
        List<DateSales> model3Sales = fileReader.readFile(MODEL_3_PATH);

        for (DateSales dateSale : model3Sales)
        {
            System.out.println("Date: " + dateSale.getDate() + " Sales: " + dateSale.getNumSales());
        }

    }
}
