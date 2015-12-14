package com.competition.client.ScoreCounter;

/**
 * Created by Kestutis on 2015.12.13.
 */
public class CountScoreByEvent {

    public CountScore getScore(String eventType){

        if(eventType == null){
            return null;
        }

        switch (eventType){
            case "TIME":
                return new CountTimeScoreEvent();
            case "RANGE":
                return new CountRangeScoreEvent();
        }
        return null;
    }
}
