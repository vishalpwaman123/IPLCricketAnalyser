package com.analyser;

import java.util.Map;

public class IplAdapterFactory {

    public Map<String, IplRecordDAO> cricketleagueFactory(IplGivenEntity iplEntity, String... csvFilePath) throws IplAnalyserException {
        if (iplEntity.equals(iplEntity.BATTING))
            return new BatsmanModeAdapter().loadIPLData(iplEntity, csvFilePath);
        return new BollerModeAdapter().loadIPLData(iplEntity, csvFilePath);
    }


}
