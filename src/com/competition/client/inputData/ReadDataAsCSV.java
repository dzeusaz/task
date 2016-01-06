package com.competition.client.inputData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kestutis on 2015.12.28.
 */
public class ReadDataAsCSV extends ReadData {

    private String filepath;

    public ReadDataAsCSV(String filepath, DataReaderAPI dataReaderAPI) {
        super(dataReaderAPI);
        this.filepath = filepath;
    }

    @Override
    public List<DecathlonData> parseDecathlonData() {
       return  setAthleteData(dataReaderAPI.readDataFromFile(filepath));
    }

    private List<DecathlonData> setAthleteData(List<String[]> athleteList){
        List<DecathlonData> decathlonDataList = new ArrayList<>();
        for(String[] athlete: athleteList ) {
            DecathlonData athleteData = new DecathlonData();
            athleteData.setAthleteName(athlete[0]);
            athleteData.setRun_100_metres(Double.parseDouble(athlete[1]));
            athleteData.setLongJump(Double.parseDouble(athlete[2]) * 100);
            athleteData.setShotPut(Double.parseDouble(athlete[3]));
            athleteData.setHighJump(Double.parseDouble(athlete[4]) * 100);
            athleteData.setRun_400_metres(Double.parseDouble(athlete[5]));
            athleteData.setRun_110_metres(Double.parseDouble(athlete[6]));
            athleteData.setDiscusThrow(Double.parseDouble(athlete[7]));
            athleteData.setPoleVault(Double.parseDouble(athlete[8]) * 100);
            athleteData.setJavelinThrow(Double.parseDouble(athlete[9]));
            athleteData.setRun_1500_metres(parseTime(athlete[10]));
            decathlonDataList.add(athleteData);
        }
        return decathlonDataList;
    }

    private double parseTime(String time){

        double seconds = 0.0;
        double minutes = 0.0;
        Pattern pattern = Pattern.compile("^(\\d+).(\\d{2}).(\\d{2})");
        Matcher matcher = pattern.matcher(time);
        while(matcher.find())
        {
            minutes = Double.valueOf(matcher.group(1));
            seconds = (minutes*60) + Double.valueOf(matcher.group(2)) + Double.valueOf("0." + matcher.group(3));
        }
        return seconds;
    }

}
