package com.analyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;


public abstract class OpenCSVBuilder<E> implements ICSVBuilder {

    public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
        return this.getCSVBean(reader,csvClass).iterator();
    }

    private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CSVBuilderException {

        try{
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return  csvToBeanBuilder.build();
        }catch(IllegalStateException e){
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);

        }
    }
}