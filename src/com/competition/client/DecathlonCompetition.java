package com.competition.client;

import com.competition.client.finalResultCreation.GetDecathlonFinalResult;
import com.competition.client.inputData.ReadDataFromStreamAPI;
import com.competition.client.inputData.ReadDataAsCSV;
import com.competition.client.inputData.ReadData;
import com.competition.client.outputData.WriteData;
import com.competition.client.outputData.WriteDataAsXSL;
import com.competition.client.outputData.WriteDataToStreamAPI;

/**
 * Created by Kestutis on 2016.01.06.
 */
public class DecathlonCompetition {

    public DecathlonCompetition(){

        ReadData decathlonData = new ReadDataAsCSV(Constants.INPUT_PATH, new ReadDataFromStreamAPI());
        GetDecathlonFinalResult finalResult =  new GetDecathlonFinalResult(decathlonData.parseDecathlonData());
        WriteData finalDecathlonData = new WriteDataAsXSL(Constants.OUTPUT_PATH, new WriteDataToStreamAPI());
        finalDecathlonData.writeDataAsXSL(finalResult.getDecathlonFinalResult());
    }
}
