package com.competition.client.inputData;

import java.util.List;

/**
 * Created by Kestutis on 2015.12.28.
 */
public abstract class ReadData {
    protected DataReaderAPI dataReaderAPI;

    protected ReadData(DataReaderAPI dataReaderAPI){
        this.dataReaderAPI = dataReaderAPI;
    }

    public abstract List<DecathlonData> parseDecathlonData();
}
