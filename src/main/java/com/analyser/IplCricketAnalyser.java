package com.analyser;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IplCricketAnalyser {

    Map<String, IplRecordDAO> iplDataMap;
    public IplGivenEntity iplEntity;

    public IplCricketAnalyser(IplGivenEntity iplEntity) {
        this.iplEntity=iplEntity;
    }

    public  int loadIplData(String... csvFilePath) throws IplAnalyserException {
        iplDataMap=new IplAdapterFactory().cricketleagueFactory(iplEntity,csvFilePath);
        return iplDataMap.size();
    }

    public String Sorting(SortedByField.Parameter parameter) throws IplAnalyserException {
        Comparator<IplRecordDAO> iplComparator;
        if(iplDataMap ==null || iplDataMap.size()==0){
            throw new IplAnalyserException("no runs data",IplAnalyserException.ExceptionType.NO_IPL_DATA);        }
        iplComparator = SortedByField.getParameter(parameter);
        ArrayList sortedData= iplDataMap.values()
                .stream()
                .sorted(iplComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        String sortedDataInJson=new Gson().toJson(sortedData);
        return sortedDataInJson;
    }
}
