package com.analyser;


//import com.Csv.CSVBuilderException;
//import com.Csv.CSVBuilderFactory;
//import com.Csv.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatsmanModeAdapter extends IplAdapter {
    @Override
    public Map<String, IplRecordDAO> loadIPLData(IplGivenEntity iplEntity, String... csvFilePath) throws IplAnalyserException {
        Map<String, IplRecordDAO> recordDAOMap = super.loadIPLData(IplMostRunsCSV.class, csvFilePath[0]);
        if (csvFilePath.length == 2)
            this.loadMostWKTSCSV(recordDAOMap, csvFilePath[1]);
        return recordDAOMap;
    }

    private int loadMostWKTSCSV(Map<String, IplRecordDAO> recordDAOMap, String csvFilePath) throws IplAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostWktsCSV> wktsCSVIterator = csvBuilder.getCSVFileIterator(reader, IplMostWktsCSV.class);
            Iterable<IplMostWktsCSV> wktsCSVS = () -> wktsCSVIterator;
            StreamSupport.stream(wktsCSVS.spliterator(), false)
                    .filter(csvIPL -> recordDAOMap.get(csvIPL.player) != null)
                    .forEach(mostWktsCSV -> {
                        recordDAOMap.get(mostWktsCSV.player).bowlingAverage = mostWktsCSV.average;
                        recordDAOMap.get(mostWktsCSV.player).wickets = mostWktsCSV.Wickets;
                    });
            return recordDAOMap.size();
        } catch (IOException | CSVBuilderException e) {
            e.printStackTrace();
        }
        return recordDAOMap.size();
    }
}

