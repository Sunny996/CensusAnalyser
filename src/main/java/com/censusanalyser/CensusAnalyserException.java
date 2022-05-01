package com.censusanalyser;

public class CensusAnalyserException extends RuntimeException {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, NO_CENSUS_DATA, CSV_FILE_INTERNAL_ISSUES
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
