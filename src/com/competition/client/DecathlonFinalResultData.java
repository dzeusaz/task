package com.competition.client;

/**
 * Created by Kestutis on 2015.12.13.
 */
public class DecathlonFinalResultData {

    private String athleteName;
    private Integer totalScore;
    private Integer position;
    private Integer sharePositionWith;

    public DecathlonFinalResultData(String athleteName, Integer totalScore, Integer position, int sharePositionWith){
        this.athleteName = athleteName;
        this.totalScore = totalScore;
        this.position = position;
        this.sharePositionWith = sharePositionWith;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getSharePositionWith() {
        return sharePositionWith;
    }
    public void setSharePositionWith(Integer sharePositionWith) {
        this.sharePositionWith = sharePositionWith;
    }
}
