package com.analyser;

public class IplWicketsDAO {
    public String player;
    public int match;
    public int highestStrike;
    public float average;
    public int runs;
    public int noOfSix;
    public int noOfFour;
    public float strikeRate;
    public int Fourwicket;
    public int Fivewicket;
    public float economicsRate;
    public int Wickets;


    public int inning;

    public IplWicketsDAO(IplMostRunsCSV iplMostRunsCSV) {
        player = iplMostRunsCSV.player;
        runs = iplMostRunsCSV.runs;
        highestStrike = iplMostRunsCSV.highestStrike;
        average =iplMostRunsCSV.Battingaverage;
        strikeRate=iplMostRunsCSV.strikeRate;
        match=iplMostRunsCSV.match;
        inning=iplMostRunsCSV.inning;
        highestStrike=iplMostRunsCSV.highestStrike;
        }


    public IplWicketsDAO(IplMostWktsCSV iplMostWktsCSV) {
        player = iplMostWktsCSV.player;
        match = iplMostWktsCSV.match;
        average =iplMostWktsCSV.bollingaverage;
        runs = iplMostWktsCSV.runs;
        strikeRate=iplMostWktsCSV.strikeRate;
        economicsRate=iplMostWktsCSV.economicsRate;
        Fivewicket=iplMostWktsCSV.Fivewicket;
        Fourwicket=iplMostWktsCSV.Fourwicket;
        Wickets=iplMostWktsCSV.Wickets;
    }
}
