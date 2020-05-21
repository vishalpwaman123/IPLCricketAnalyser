package com.analyser;

public class IplRunsDAO {
    public String player;
    public int match;
    public int inning;
    public float average;
    public int runs;
    public float strikeRate;
    public int noOfFour;
    public int noOfSix;
    public int highestStrike;


    public IplRunsDAO(IplMostRunsCSV iplMostRunsCSV) {
         player = iplMostRunsCSV.player;
         match = iplMostRunsCSV.match;
         inning = iplMostRunsCSV.inning;
         average =iplMostRunsCSV. average;
        strikeRate = iplMostRunsCSV.strikeRate;
        noOfFour = iplMostRunsCSV.noOfFour;
        noOfSix =iplMostRunsCSV.noOfSix;
        highestStrike =iplMostRunsCSV.highestStrike;
    }
    public IplRunsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        match = iplMostWktsCSV.match;
        inning = iplMostWktsCSV.inning;
        average =iplMostWktsCSV. average;
        runs = iplMostWktsCSV.runs;

    }
}
