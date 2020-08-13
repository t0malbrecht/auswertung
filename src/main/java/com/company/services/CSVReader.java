package com.company.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    private static String CSV_FILE_PATH;
    private ArrayList<QuestionObject> questions = new ArrayList<QuestionObject>();

    public static void setCsvFilePath(String path){
        CSV_FILE_PATH = path;
    }

    public static String getCsvFilePath(){
        return CSV_FILE_PATH;
    }

    public ArrayList<QuestionObject> getList() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Number","Name","Code","Inverted")
                        .withIgnoreHeaderCase()
                        .withTrim())

        ) {
            List<CSVRecord> csvRecord = csvParser.getRecords().stream()
                    .filter(record -> record.getRecordNumber() != 1)
                    .collect(Collectors.toList());
            for (CSVRecord csvRecord1 : csvRecord) {
                boolean temp =false;
                if(csvRecord1.get("Inverted").equals("i")){
                    temp = true;
                }
                questions.add(new QuestionObject(
                        Integer.parseInt(csvRecord1.get("Number")),
                        csvRecord1.get("Name"),
                        Integer.parseInt(csvRecord1.get("Code")),
                        temp
                ));
            }
        }
        return questions;
    }

}