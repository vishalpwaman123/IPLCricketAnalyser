package com.analyser;

public class IPLRunBowDAO {

    public String player;
    public int innings;
    public int match;
    public int runs;
    public double battingAverage;
    public double strikeRate;
    public int fours;
    public int sixes;
    public double sixesAndFours;
    public double strikeRateWithSixesAndFours;
    public double averageWithStrikingRate;
    public double runsWithAverages;

    public double bowlingAverage;
    public double over;
    public int wickets;
    public double bestBowlingIn;
    public double economyRate;
    public int fourWickets;
    public int fiveWickets;
    public double strikeRateWith5wAnd4w;
    public double bowlerAveragesWithStrikingRate;
    public double wicketsWithBowlerAverage;



    public IPLRunBowDAO(IplMostRunsCSV iplRunsheetCSV) {
        this.player = iplRunsheetCSV.player;
        this.runs = iplRunsheetCSV.runs;
        this.battingAverage=iplRunsheetCSV.Battingaverage;
        this.strikeRate = iplRunsheetCSV.strikeRate;
        this.fours = iplRunsheetCSV.noOfFour;
        this.sixes = iplRunsheetCSV.noOfSix;
        this.sixesAndFours=iplRunsheetCSV.noOfSix*iplRunsheetCSV.noOfFour;
        this.strikeRateWithSixesAndFours=iplRunsheetCSV.strikeRate*iplRunsheetCSV.noOfSix*iplRunsheetCSV.noOfFour;
        this.averageWithStrikingRate=iplRunsheetCSV.Battingaverage*iplRunsheetCSV.strikeRate;
        this.runsWithAverages=iplRunsheetCSV.runs*iplRunsheetCSV.Battingaverage;
    }

    public IPLRunBowDAO(IplMostWktsCSV iplWicketSheetCSV) {
        this.player = iplWicketSheetCSV.player;
        this.match = iplWicketSheetCSV.match;
        this.innings=iplWicketSheetCSV.inning;
        this.over = iplWicketSheetCSV.over;
        this.runs = iplWicketSheetCSV.runs;
        this.wickets = iplWicketSheetCSV.Wickets;
        this.bestBowlingIn = iplWicketSheetCSV.bestBowlingIn;
        this.bowlingAverage = iplWicketSheetCSV.bollingaverage;
        this.economyRate = iplWicketSheetCSV.economicsRate;
        this.strikeRate = iplWicketSheetCSV.strikeRate;
        this.fourWickets = iplWicketSheetCSV.Fourwicket;
        this.fiveWickets = iplWicketSheetCSV.Fivewicket;
        this.strikeRateWith5wAnd4w=iplWicketSheetCSV.strikeRate*iplWicketSheetCSV.Fourwicket*iplWicketSheetCSV.Fivewicket;
        this.bowlerAveragesWithStrikingRate=iplWicketSheetCSV.strikeRate*iplWicketSheetCSV.bollingaverage;
        this.wicketsWithBowlerAverage=iplWicketSheetCSV.Wickets*iplWicketSheetCSV.bollingaverage;
    }
}