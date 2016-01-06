package com.competition.client.inputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kestutis on 2015.12.31.
 */
public class ReadDataFromStreamAPI implements DataReaderAPI {
    @Override
    public List<String[]> readDataFromFile(String Filepath) {
        BufferedReader buffer = null;
        String line = "";
        String split = ";";
        String[] athlete = null;
        List<String[]> inputDataList = new ArrayList<>();

        try {
            buffer = new BufferedReader(new FileReader(Filepath));
            while ((line = buffer.readLine()) != null) {
                athlete = line.split(split);
                inputDataList.add(athlete);
            }
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return inputDataList;
    }

}
