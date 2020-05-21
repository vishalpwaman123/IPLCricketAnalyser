package com.analyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplCricketTest {
    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostRuns.csv";
    private static final String IPL_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostWkts.csv";
    //private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPLFactsheetMostRuns.csv";

    IplCricketAnalyser iplAnalyser = new IplCricketAnalyser();

    @Test
    public void givenIplMostRun_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {

        int numberOfRecord = iplAnalyser.loadIplMostRunData(IPL_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(100, numberOfRecord);

    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostRunData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnBattingAverage();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnStrikeRate_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostRunData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnStrikeRate();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(4.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxSix_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostRunData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadMaximumSixInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell",iplBatsManData[99].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
