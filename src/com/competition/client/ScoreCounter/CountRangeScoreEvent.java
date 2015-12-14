package com.competition.client.ScoreCounter;

/**
 * Created by Kestutis on 2015.12.13.
 */
public class CountRangeScoreEvent implements CountScore{


    @Override
    public Integer countScore(double parameterA, double parameterB, double parameterC, double result) {
        return  (int) (parameterA * Math.pow((result - parameterB ), parameterC));
    }
}
