package com.competition;

import com.competition.client.*;

public class Main {

    public static void main(String[] args) {
        new GetDecathlonCompetitionData();
        GetDecathlonCompetitionData result = new GetDecathlonCompetitionData();
        String inputFile = "src/com/competition/client/resources/Decathlon_input.txt";
        GetDecathlonFinalResult finalResult = new GetDecathlonFinalResult(result.getData(inputFile));
        new CreateXML(finalResult.getDecathlonFinalResult(), "src/com/competition/client/resources/DecathlonResult.xml");
    }


}
