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
         average =iplMostRunsCSV.Battingaverage ;
        strikeRate = iplMostRunsCSV.strikeRate;
        noOfFour = iplMostRunsCSV.noOfFour;
        noOfSix =iplMostRunsCSV.noOfSix;
        highestStrike =iplMostRunsCSV.highestStrike;
        runs =iplMostRunsCSV.runs;
    }
    public IplRunsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        match = iplMostWktsCSV.match;
        inning = iplMostWktsCSV.inning;
        average =iplMostWktsCSV. bollingaverage;
        runs = iplMostWktsCSV.runs;

    }
}
