package com.competition.client.inputData;

import java.util.List;

/**
 * Created by Kestutis on 2015.12.30.
 */
public interface DataReaderAPI {
    List<String[]> readDataFromFile(String path);
}
