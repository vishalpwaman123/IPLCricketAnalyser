package com.analyser;

import java.util.Map;

public class BollerModeAdapter extends IplAdapter {

    @Override
    public Map<String, IplRecordDAO> loadIPLData(IplGivenEntity iplEntity, String... csvFilePath) throws IplAnalyserException {
        Map<String, IplRecordDAO> recordDAOMap = super.loadIPLData(IplMostWktsCSV.class, csvFilePath);
        return recordDAOMap;
    }
}