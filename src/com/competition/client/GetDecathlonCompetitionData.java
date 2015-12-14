package com.competition.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kestutis on 2015.12.12.
 */
public class GetDecathlonCompetitionData {


    public List<DecathlonData> getData(String inputPath){

        ArrayList<DecathlonData> decathlonDataList = new ArrayList<>();
        BufferedReader buffer = null;
        String line = "";
        String split  = ";";

        try{
            buffer = new BufferedReader(new FileReader(inputPath));
            while ((line = buffer.readLine()) != null) {
                String[] athlete = line.split(split);
                decathlonDataList.add(setAthleteData(athlete));

            }
        }catch (FileSystemNotFoundException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }

        finally {

            if(buffer != null){
                try {
                    buffer.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        }
        return decathlonDataList;
    }

    private DecathlonData setAthleteData(String[] athlete){
        DecathlonData athleteData = new DecathlonData();
        athleteData.setAthleteName(athlete[0]);
        athleteData.setRun_100_metres(Double.parseDouble(athlete[1]));
        athleteData.setLongJump(Double.parseDouble(athlete[2])*100);
        athleteData.setShotPut(Double.parseDouble(athlete[3]));
        athleteData.setHighJump(Double.parseDouble(athlete[4])*100);
        athleteData.setRun_400_metres(Double.parseDouble(athlete[5]));
        athleteData.setRun_110_metres(Double.parseDouble(athlete[6]));
        athleteData.setDiscusThrow(Double.parseDouble(athlete[7]));
        athleteData.setPoleVault(Double.parseDouble(athlete[8])*100);
        athleteData.setJavelinThrow(Double.parseDouble(athlete[9]));
        athleteData.setRun_1500_metres(parseTime(athlete[10]));

        return athleteData;
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
