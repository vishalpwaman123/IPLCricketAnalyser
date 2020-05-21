package com.analyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IplDataLoader {

    public Map<String, IPLRunBowDAO> loadIplRunsSheetData(Class<IplMostRunsCSV> csvClass, String csvFilePath) throws IplAnalyserException {
        Map<String, IPLRunBowDAO> iplRunsMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostRunsCSV> csvIterator = csvBuilder.getCSVfileIterator(reader, csvClass);
            Iterable<IplMostRunsCSV> csvIterable = () -> csvIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .forEach(iplRunsCSV -> iplRunsMap.
                            put(iplRunsCSV.player, new IPLRunBowDAO(iplRunsCSV)));
            return iplRunsMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iplRunsMap;
    }


    public Map<String, IPLRunBowDAO> loadIplWktsSheetData(Class<IplMostWktsCSV> csvClass, String csvFilePath) throws IplAnalyserException {
        Map<String,IPLRunBowDAO> iplWktsMap=new HashMap<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostWktsCSV> csvIterator=csvBuilder.getCSVfileIterator(reader,csvClass);
            Iterable<IplMostWktsCSV> csvIterable=()->csvIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .forEach(iplWktsCSV -> iplWktsMap.
                            put(iplWktsCSV.player,new IPLRunBowDAO(iplWktsCSV)));
            return iplWktsMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iplWktsMap;
    }
}