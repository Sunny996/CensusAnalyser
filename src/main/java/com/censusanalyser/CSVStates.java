package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
    @CsvBindByName(column="state",required=true)
    public String state;

    @CsvBindByName(column = "code", required = true)
    public String code;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", Code='" + code + '\'' +
                '}';
    }
}
