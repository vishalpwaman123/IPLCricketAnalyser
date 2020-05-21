package com.analyser;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IplCricketAnalyser {

    public Map<String, IPLRunBowDAO> iplMap = new HashMap<String, IPLRunBowDAO>();

    Map<String, IPLRunBowDAO> iplRunsSheetMap =null;
    Map<String, IPLRunBowDAO> iplWktsSheetMap=null;
    Map<String, IPLRunBowDAO> iplRunsWktsSheetMap=null;

    List<IplWicketsDAO> iplWicketsList;

    public IplCricketAnalyser() {
        this.iplWicketsList = new ArrayList<>();
        this.iplRunsSheetMap =new HashMap<String, IPLRunBowDAO>();
        this.iplWktsSheetMap=new HashMap<String, IPLRunBowDAO>();
        this.iplRunsWktsSheetMap=new HashMap<String, IPLRunBowDAO>();
    }

    public  int loadIplRunsSheetData(String csvFilePath) throws IplAnalyserException {
        iplRunsSheetMap=new IplDataLoader().loadIplRunsSheetData(IplMostRunsCSV.class,csvFilePath);
        return iplRunsSheetMap.size();
    }

    public int loadIplWktsSheetData(String csvFilePath) throws IplAnalyserException {
        iplWktsSheetMap=new IplDataLoader().loadIplWktsSheetData(IplMostWktsCSV.class,csvFilePath);
        return iplWktsSheetMap.size();
    }

    private Map<String, IPLRunBowDAO> loadBothRunsandWktsSheet(Map<String,IPLRunBowDAO> iplRunsSheetMap, Map<String,IPLRunBowDAO> iplWktsSheetMap) {
        iplRunsWktsSheetMap.putAll(iplRunsSheetMap);
        iplRunsWktsSheetMap.putAll(iplWktsSheetMap);
        return iplRunsWktsSheetMap;
    }

    public int loadIplMostWicketData(String csvFilePath) throws IplAnalyserException{
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplMostWktsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplMostWktsCSV.class);
            while (csvFileIterator.hasNext()) {
                this.iplWicketsList.add(new IplWicketsDAO(csvFileIterator.next()));
            }
            return this.iplWicketsList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
    }

    public String loadSortedOnBattingAverage() throws IplAnalyserException {

        Comparator<IplWicketsDAO> averageComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.average);
        return sort(averageComparator);
    }

    public String loadSortedOnStrikeRate() throws IplAnalyserException {

        Comparator<IplWicketsDAO> strikeRateComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.strikeRate);
        return sort(strikeRateComparator);
    }

    public String loadMaximumSixInIpl() throws IplAnalyserException {

        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.noOfSix);
        return sort(maxNoOfSixComparator);

    }

    public String loadMaximumFourInIpl() throws IplAnalyserException {

        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.noOfFour);
        return sort(maxNoOfSixComparator);

    }

    public String loadHighestStrikeInIpl() throws IplAnalyserException {

        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.highestStrike);
        return sort(maxNoOfSixComparator);

    }

    public String loadHighestRunInIpl() throws IplAnalyserException {

        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.runs);
        return sort(maxNoOfSixComparator);

    }

    public String loadSortedOnBollingAverage() throws IplAnalyserException {
        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.average);
        return sort(maxNoOfSixComparator);
    }

    public String loadBestStrikeRateOfPlayerFromIplWktsData() throws IplAnalyserException {

        Comparator<IplWicketsDAO> maxNoOfSixComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.strikeRate);
        return sort(maxNoOfSixComparator);

    }

    public String loadBesteconomyRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplWicketsDAO> BolingAvgComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.economicsRate);
        return sort(BolingAvgComparator);
    }

    public String loadBestFourWckStrikeRateOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplWicketsDAO> BolingAvgComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.Fourwicket);
        return sort(BolingAvgComparator);
    }

    public String loadBestFiveWcktStrikeRateOfPlayerFromIplWktsData() throws IplAnalyserException{
        Comparator<IplWicketsDAO> BolingAvgComparator =Comparator.comparing(iplcricketdata -> iplcricketdata.Fivewicket);
        return sort(BolingAvgComparator);
    }

    public String loadHighestWiketsOfPlayerFromIplWktsData() throws IplAnalyserException {
        Comparator<IplWicketsDAO> strikngRate4WComparator =Comparator.comparing(census -> census.Wickets);
        return sort(strikngRate4WComparator);
    }

    public String getSortedByBattingAndBowlingAverage() throws IplAnalyserException {
        Comparator<IPLRunBowDAO> iplCSVComparatorBattingAverage=Comparator.comparing(average->average.battingAverage);
        Comparator<IPLRunBowDAO> iplCSVComparatorBowlingAverage=iplCSVComparatorBattingAverage.thenComparing(average->average.bowlingAverage);
        return sorting(iplCSVComparatorBowlingAverage);
    }

    public String getRunsandWicketsWiseSortedData() throws IplAnalyserException {
        loadBothRunsandWktsSheet(iplRunsSheetMap,iplWktsSheetMap);
        Comparator<IPLRunBowDAO> iplComparatorRuns =Comparator.comparing(ipl->ipl.runs);
        Comparator<IPLRunBowDAO> iplComparatorRunsWickets=iplComparatorRuns.thenComparing(ipl->ipl.wickets);
        return this.sorting(iplComparatorRunsWickets);
    }

    private String sorting(Comparator<IPLRunBowDAO> averageComparator) throws IplAnalyserException {

        if(iplMap == null || iplMap.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }
        List sortedAvgRunsData =iplMap.values()
                .stream()
                .sorted(averageComparator)
                .collect(Collectors.toList());
        String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
        return sortedAverageRunsDataInJson;
    }


        private String sort(Comparator<IplWicketsDAO> averageComparator) throws IplAnalyserException {

        if(iplWicketsList == null || iplWicketsList.size() ==0 ) {
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);
        }
        List sortedAvgRunsData =iplWicketsList
                .stream()
                .sorted(averageComparator)
                .collect(Collectors.toList());
        String sortedAverageRunsDataInJson = new Gson().toJson(sortedAvgRunsData);
        return sortedAverageRunsDataInJson;
    }


}
