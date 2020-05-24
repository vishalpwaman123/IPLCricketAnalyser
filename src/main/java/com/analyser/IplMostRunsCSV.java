package com.analyser;
import com.opencsv.bean.CsvBindByName;
public class IplMostRunsCSV {
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int inning;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "6s", required = true)
    public int noOfSix;

    @CsvBindByName(column = "4s", required = true)
    public int noOfFour;

    @CsvBindByName(column = "HS", required = true)
    public int highestStrike;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    public IplMostRunsCSV(String player, double battingAverage, double battingStrikeRate, int sixes, int fours, int battingRuns) {
    }

    @Override
    public String toString() {
        return "IplMostRunsCSV{" +
                "player='" + player + '\'' +
                ", match='" + match + '\'' +
                ", inning='" + inning + '\'' +
                ", average='" + average + '\'' +
                ", strikeRate='" + strikeRate + '\'' +
                ", noOfSix='" + noOfSix + '\'' +
                ", noOfFour='" + noOfFour + '\'' +
                ", highestStrike='" + highestStrike + '\'' +
                ", run='" + runs + '\'' +
                '}';
    }
}
