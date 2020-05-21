package com.analyser;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IplCricketAnalyser {


    List<IplRunsDAO> iplRunsList;

    public IplCricketAnalyser() {
        this.iplRunsList = new ArrayList<>();
    }

    public int loadIplMostRunData(String csvFilePath) throws IplAnalyserException{
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplMostRunsCSV.class);
            while (csvFileIterator.hasNext()) {
                this.iplRunsList.add(new IplRunsDAO(csvFileIterator.next()));
            }
            return this.iplRunsList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public String loadSortedOnBattingAverage() throws IplAnalyserException {

        Comparator<IplRunsDAO> averageComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.average);
        return sort(averageComparator);
    }

    public String loadSortedOnStrikeRate() throws IplAnalyserException {

        Comparator<IplRunsDAO> strikeRateComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.strikeRate);
        return sort(strikeRateComparator);
    }

    public String loadMaximumSixInIpl() throws IplAnalyserException {

        Comparator<IplRunsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.noOfSix);
        return sort(maxNoOfSixComparator);

    }

    public String loadMaximumFourInIpl() throws IplAnalyserException {

        Comparator<IplRunsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.noOfFour);
        return sort(maxNoOfSixComparator);

    }

    public String loadHighestStrikeInIpl() throws IplAnalyserException {

        Comparator<IplRunsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.highestStrike);
        return sort(maxNoOfSixComparator);

    }

    public String loadHighestRunInIpl() throws IplAnalyserException {

        Comparator<IplRunsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.runs);
        return sort(maxNoOfSixComparator);

    }

        private String sort(Comparator<IplRunsDAO> averageComparator) throws IplAnalyserException {

        if(iplRunsList == null || iplRunsList.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }
        List sortedAvgRunsData =iplRunsList
                .stream()
                .sorted(averageComparator)
                .collect(Collectors.toList());
        String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
        return sortedAverageRunsDataInJson;
    }

}
