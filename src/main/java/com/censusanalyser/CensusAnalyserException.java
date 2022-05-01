package com.censusanalyser;

public class CensusAnalyserException extends RuntimeException {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        CENSUS_INCORRECT_FILE_FORMAT,
        WRONG_FILE_PATH,
        CSV_FILE_INTERNAL_ISSUE
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
