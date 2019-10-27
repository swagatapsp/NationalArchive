package com.nationalarchive.csvreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class NationalArchiveCSVParser {

    void updateRowValues(String csvFileName, String column, String oldValue, String newValue) {
        try {
            CSVReader reader = new CSVReader(new FileReader(new File(csvFileName)), ',');
            List<String[]> csvFile = reader.readAll();
            int columnIndex = 0;
            for(int i=0; i < csvFile.size(); i++) {
                String[] row = csvFile.get(i);
                for(int j=0; j < row.length; j++) {
                    if (i==0 && row[j].toString().trim().equals(column)) {
                        columnIndex = j;
                    }
                    if(j==columnIndex && row[j].trim().equalsIgnoreCase(oldValue)) {
                        csvFile.get(i)[j] = newValue;
                    }
                }
            }
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(csvFileName), ',');
            writer.writeAll(csvFile);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
