package com.analyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplCricketTest {
    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostRuns.csv";
    private static final String IPL_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostWkts.csv";
    //private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPLFactsheetMostRuns.csv";

    @Test
    public void givenIplMostRun_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {
        IplCricketAnalyser iplAnalyser = new IplCricketAnalyser();
        int numberOfRecord = iplAnalyser.loadIplMostRunData(IPL_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(100, numberOfRecord);

    }

}
