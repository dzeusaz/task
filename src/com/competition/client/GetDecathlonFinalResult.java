package com.competition.client;

import com.competition.client.ScoreCounter.CountScore;
import com.competition.client.ScoreCounter.CountScoreByEvent;

import java.util.*;

/**
 * Created by Kestutis on 2015.12.13.
 */
public class GetDecathlonFinalResult {

    private List<DecathlonData> decathlonData;
    private List<DecathlonFinalResultData> finalResult = new ArrayList<>();
    private Map<String, Integer> athleteTotalScore = new HashMap<>();

    public GetDecathlonFinalResult(List<DecathlonData> decathlonData){
        this.decathlonData = decathlonData;
        countTotalScore();

        finalDecathlonResultData(getPlace(athleteTotalScore));
    }

    private Integer getScore(double parameterA, double parameterB, double parameterC, double eventResult, String eventType){
        CountScoreByEvent event = new CountScoreByEvent();
        CountScore score = event.getScore(eventType);
        return  score.countScore(parameterA, parameterB, parameterC, eventResult);

    }

    private void countTotalScore() {
        for(DecathlonData data : decathlonData)
        {
            int totalScore = 0;
            data.getAthleteName();
            totalScore += getScore(Constants.RUN_100_METRES_A, Constants.RUN_100_METRES_B, Constants.RUN_100_METRES_C , data.getRun_100_metres(), Constants.TIME_EVENT);
            totalScore += getScore(Constants.LONG_JUMP_A, Constants.LONG_JUMP_B, Constants.LONG_JUMP_C, data.getLongJump(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.SHOT_PUT_A, Constants.SHOT_PUT_B, Constants.SHOT_PUT_C, data.getShotPut(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.HIGH_JUMP_A, Constants.HIGH_JUMP_B, Constants.HIGH_JUMP_C, data.getHighJump(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.RUN_400_METRES_A, Constants.RUN_400_METRES_B, Constants.RUN_400_METRES_C, data.getRun_400_metres(), Constants.TIME_EVENT);
            totalScore += getScore(Constants.RUN_110_METRES_A, Constants.RUN_110_METRES_B, Constants.RUN_110_METRES_C, data.getRun_110_metres(), Constants.TIME_EVENT);
            totalScore += getScore(Constants.DISCUS_THROW_A, Constants.DISCUS_THROW_B, Constants.DISCUS_THROW_C, data.getDiscusThrow(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.POLE_VAULT_A, Constants.POLE_VAULT_B, Constants.POLE_VAULT_C, data.getPoleVault(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.JAVELIN_THROW_A, Constants.JAVELIN_THROW_B, Constants.JAVELIN_THROW_C, data.getJavelinThrow(), Constants.RANGE_EVENT);
            totalScore += getScore(Constants.RUN_1500_METRES_A, Constants.RUN_1500_METRES_B, Constants.RUN_1500_METRES_C, data.getRun_1500_metres(), Constants.TIME_EVENT);
            athleteTotalScore.put(data.getAthleteName(), totalScore);
        }
    }

    private Map<String, Integer> getPlace(Map<String, Integer> athleteScore) {

        List<Map.Entry<String, Integer>> sorter = new LinkedList<Map.Entry<String, Integer>>(athleteScore.entrySet());

        Collections.sort(sorter, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> score1, Map.Entry<String, Integer> score2) {
                return (score2.getValue()).compareTo(score1.getValue());
            }
        });
        Map<String, Integer> sortByScore = new LinkedHashMap<String, Integer>();
        for(Iterator<Map.Entry<String, Integer>> iterator = sorter.iterator(); iterator.hasNext();)
        {
            Map.Entry<String, Integer> entry = iterator.next();
            sortByScore.put(entry.getKey(), entry.getValue());
        }
        return sortByScore;
    }

    private void finalDecathlonResultData(Map<String, Integer> athleteTotalScore){
        int position = 0;
        int score1 = -1;
        int score2 = -1;
        int raiseNextPosition = 0;

        for(String name : athleteTotalScore.keySet()){
            score1 = athleteTotalScore.get(name);
            if(score1 != score2){
                position++;
                raiseNextPosition =0;
            }else{
                raiseNextPosition++;
                finalResult.get(position-1).setSharePositionWith(raiseNextPosition);
            }
            finalResult.add(new DecathlonFinalResultData(name, athleteTotalScore.get(name), position, raiseNextPosition));
            score2 = athleteTotalScore.get(name);
        }
    }
    public List<DecathlonFinalResultData> getDecathlonFinalResult(){
        return finalResult;
    }

}
