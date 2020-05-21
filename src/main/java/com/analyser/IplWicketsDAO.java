package com.analyser;

public class IplWicketsDAO {
    public String player;
    public int match;
    public int highestStrike;
    public float average;
    public int runs;
    public float strikeRate;
    public int noOfSix;
    public int noOfFour;


    public IplWicketsDAO(IplMostRunsCSV iplMostRunsCSV) {
        player = iplMostRunsCSV.player;
        runs = iplMostRunsCSV.runs;
        highestStrike = iplMostRunsCSV.highestStrike;
        average =iplMostRunsCSV. average;
        strikeRate=iplMostRunsCSV.strikeRate;
        noOfSix=iplMostRunsCSV.noOfSix;
        noOfFour=iplMostRunsCSV.noOfFour;
    }
    public IplWicketsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        match = iplMostWktsCSV.match;
        //inning = iplMostWktsCSV.inning;
        average =iplMostWktsCSV. average;
        runs = iplMostWktsCSV.runs;

    }
}
