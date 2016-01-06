package com.competition.client.outputData;

import com.competition.client.finalResultCreation.DecathlonFinalResultData;

import javax.xml.transform.stream.StreamResult;
import java.util.List;

/**
 * Created by Kestutis on 2016.01.05.
 */
public abstract class WriteData {

    protected  DataWriterAPI dataWriteAPI;
    protected WriteData(DataWriterAPI dataWriteAPI) {this.dataWriteAPI = dataWriteAPI; }
    public abstract void writeDataAsXSL(List<DecathlonFinalResultData> decathlonFinalResultData);
}
