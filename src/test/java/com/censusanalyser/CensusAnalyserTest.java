package com.censusanalyser;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";
    private static final String CSV_WRONG_FILE_PATH = "./IndianStateCensus.csv";
    private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataWrongType.txt";
    private static final String CSV_CENSUS_WRONG_DELIMITER = "./src/test/resources/IndianCensusWrongDelimiter.csv";
    private static final String CSV_CENSUS_WRONG_HEADER = "./src/test/resources/CsvFileWrongHeader.csv";
    private static final String STATE_CSV_FILE_PATH = "./src/test/resources/IndianStateCodes.csv";
    private static final String STATE_CSV_FILE_WRONG_PATH = "./IndianStateCodes.csv";
    private static final String STATE_CSV_WRONG_TYPE = "./src/test/resources/StateCodeWrongType.txt";
    private static final String STATE_CSV_WRONG_DELIMITER = "./src/test/resources/StateCodeWrongDelimiter.csv";
    private static final String STATE_CSV_WRONG_HEADER = "./src/test/resources/StateCodeWrongHeader.csv";

    @Test
    public void loadIndiaCensusData_ValidCSVInput_NumberOfRows() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser();
        int noOfLines = analyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        assertEquals(2, noOfLines);
    }

    @Test
    public void loadIndiaCensusData_givenWrongPath_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(CSV_WRONG_FILE_PATH);

        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void loadIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }

    @Test
    public void loadIndiaStateCode_ValidCSVInput_ReturnsNumberOfRows() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser();
        int noOfLines = analyzer.loadIndiaStateCode(STATE_CSV_FILE_PATH);
        assertEquals(2, noOfLines);
    }

    @Test
    public void givenStatesData_whenWrongPath_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CSV_FILE_WRONG_PATH);

        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenStatesData_WithWrongFileType_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CSV_WRONG_TYPE);
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }

    @Test
    public void givenStatesData_statesDataWithWrongDelimiter_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUE, e.type);
        }
    }

    @Test
    public void givenStatesData_StateDataMissingHeader_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CSV_WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUE, e.type);
        }
    }
}
