package com.analyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class IplCricketTest {
    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostRuns.csv";
    private static final String IPL_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostWkts.csv";
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH_FOR_WRONG_FILE = "./src/test/resources/IPLData.csv";
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH_FOR_WRONG_EXTENSION = "./src/test/resources/IPLsheetMostRuns.jpg";




    @Test
    public void givenIplMostRun_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {
        IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
        int numberOfRecord = iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(100, numberOfRecord);
    }


    @Test
    public void givenIPLMostRunsCSVFile_whenImproperFileName_shouldReturnException() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH_FOR_WRONG_FILE);
        }catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.NO_IPL_DATA,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_whenImproperFileExtension_shouldReturnException() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUNS_CSV_FILE_PATH_FOR_WRONG_EXTENSION);
        }catch (IplAnalyserException e) {
            Assert.assertEquals(IplAnalyserException.ExceptionType.NO_IPL_DATA,e.type);
        }
    }



    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.BATTING_AVERAGE);
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average, 0.001);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnStrikeRate_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.STRIKERATE);
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals(4.0, IplDataCSV[0].average, 0.001);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxSix_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.SIX);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplBatsManData[99].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxFour_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.FOURS);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("Shikhar Dhawan", iplBatsManData[99].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBestHighestStrike_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.STRIKERATE);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("Rohit Sharma", iplBatsManData[99].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnHighestRun_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.HIGHSCORE);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("David Warner", iplBatsManData[99].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWicket_whenCountNumberOfRecord_shouldReturnShortedResult() throws IplAnalyserException {
        IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
        int numberOfRecord = iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
        Assert.assertEquals(99, numberOfRecord);

    }

    @Test
    public void givenIplMostWicketCSV_whenSortedOnBollingAverage_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.BOWLING_AVERAGE);
            IplMostWktsCSV[] IplDataCSV = new Gson().fromJson(sortedResult, IplMostWktsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average, 0.001);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedStrikeRate_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.STRIKERATE);
            IplMostWktsCSV[] IplDataCSV = new Gson().fromJson(sortedResult, IplMostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", IplDataCSV[98].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedBestEconomy_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.ECONOMY);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplBatsManData[98].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBestStriking4W5W_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.BAT_STATS_AVG_WITH_STRIKERATE);
            IplMostWktsCSV[] IplDataCSV1 = new Gson().fromJson(sortedResult, IplMostWktsCSV[].class);
            Assert.assertEquals("Lasith Malinga", IplDataCSV1[98].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnHighestWikets_shouldReturnShortedResult() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.Sorting(SortedByField.Parameter.BOWL_STATS_WKT_WITH_AVG);
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson(sortedResult, IplMostRunsCSV[].class);
            Assert.assertEquals("Imran Tahir", iplBatsManData[98].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWicketsCSVFile_ShouldReturnPlayer_WhoHadBestBattingAndBowlingAverage() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.BOWL_STATS_WKT_WITH_AVG);
            IplRecordDAO[] iplDAO = new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplDAO[iplDAO.length-1].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWicketsCSVFile_ShouldReturnPlayer_WhoHadLowBattingAndBowlingAverage() {
        try {
            IplCricketAnalyser iplAnalyser = new IplCricketAnalyser(IplGivenEntity.BOWLING);
            iplAnalyser.loadIplData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.BOWL_STATS_WKT_WITH_AVG);
            IplRecordDAO[] sortedAverageData = new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("Suresh Raina", sortedAverageData[0].player);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsandWktsFile_whenSortedOnBowlingandBattingAverages_shouldReturnBestAveragePlayer() {
        try {
            IplCricketAnalyser iplAnalyser=new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH,IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.BATTING_BOWLING_AVERAGE);
            IplRecordDAO[] sortedAverageData=new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("MS Dhoni",sortedAverageData[sortedAverageData.length-1].player);
        }catch (IplAnalyserException e) {
        }
    }

    @Test
    public void givenIPLRunsandWktsFile_whenSortedOnBowlingandBattingAverages_shouldReturnLeastAveragePlayer() {
        try {
            IplCricketAnalyser iplAnalyser=new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH,IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.BATTING_BOWLING_AVERAGE);
            IplRecordDAO[] sortedAverageData=new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("Harpreet Brar",sortedAverageData[0].player);
        }catch (IplAnalyserException e) {
        }
    }

    @Test
    public void givenIPLRunsandWktsFile_whenSortedOnRunsandWickets_shouldReturnBestAllRounderPlayer() {
        try {
            IplCricketAnalyser iplAnalyser=new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH,IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.IPL_BEST_ALLROUNDER);
            IplRecordDAO[] sortedAverageData=new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("David Warner",sortedAverageData[sortedAverageData.length-1].player);
        }catch (IplAnalyserException e) {
        }
    }

    @Test
    public void givenIPLRunsandWktsFile_whenSortedOnRunsandWickets_shouldReturnLeastAllRounderPlayer() {
        try {
            IplCricketAnalyser iplAnalyser=new IplCricketAnalyser(IplGivenEntity.BATTING);
            iplAnalyser.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH,IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedData=iplAnalyser.Sorting(SortedByField.Parameter.IPL_BEST_ALLROUNDER);
            IplRecordDAO[] sortedAverageData=new Gson().fromJson(sortedData, IplRecordDAO[].class);
            Assert.assertEquals("Tim Southee",sortedAverageData[0].player);
        }catch (IplAnalyserException e) {
        }
    }




}

