package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "state", required = true)
    public String state;

    @CsvBindByName(column = "population", required = true)
    public int population;

    @CsvBindByName(column = "area", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "density", required = true)
    public int densityPerSqKm;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", Area='" + areaInSqKm + '\'' +
                ", Density='" + densityPerSqKm + '\'' +
                '}';
    }

}
