package com.censusanalyser;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensusAnalyserTest {
    @Test
    public void loadIndiaCensusData_ValidCSVInput_NumberOfRows() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser();
        int noOfLines = analyzer.loadIndiaCensusData("data.csv");
        assertEquals(2, noOfLines);
    }

    @Test
    public void loadIndiaCensusData_givenWrongPath_returnsCorrectNumberRecords() {
        try {
            StateCensusAnalyser censusAnalyzer = new StateCensusAnalyser();
            int numOfRecords = censusAnalyzer.loadIndiaCensusData("abc.csv");

        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            StateCensusAnalyser censusAnalyzer = new StateCensusAnalyser();
            censusAnalyzer.loadIndiaCensusData("data.txt");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
        }
    }
}
