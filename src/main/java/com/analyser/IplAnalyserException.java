package com.analyser;

public class IplAnalyserException extends Throwable{
    enum ExceptionType {
        NO_IPL_DATA

    }ExceptionType type;

    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
