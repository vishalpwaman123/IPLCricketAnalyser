package com.analyser;

public class IplRecordDAO {

    public double battingAverage;
    public String player;
    public double battingStrikeRate;
    public int sixes;
    public int fours;
    public int bowlingRuns;
    public int battingRuns;
    public double bowlingAverage;
    public double bowlingStrikeRate;
    public double economy;
    public int fiveWickets;
    public int fourWickets;
    public int wickets;

    public IplRecordDAO(IplMostRunsCSV iplRunsSheetCSV) {
        this.player = iplRunsSheetCSV.player;
        this.battingAverage = iplRunsSheetCSV.average;
        this.battingStrikeRate= iplRunsSheetCSV.strikeRate;
        this.sixes= iplRunsSheetCSV.noOfSix;
        this.fours= iplRunsSheetCSV.noOfFour;
        this.battingRuns= iplRunsSheetCSV.runs;
    }

    public IplRecordDAO(IplMostWktsCSV iplWktsSheetCSV) {
        this.player =iplWktsSheetCSV.player;
        this.bowlingAverage =iplWktsSheetCSV.average;
        this.bowlingStrikeRate =iplWktsSheetCSV.strikeRate;
        this.economy=iplWktsSheetCSV.economicsRate;
        this.fiveWickets=iplWktsSheetCSV.Fivewicket;
        this.fourWickets=iplWktsSheetCSV.Fourwicket;
        this.wickets=iplWktsSheetCSV.Wickets;
        this.bowlingRuns=iplWktsSheetCSV.runs;
    }
}