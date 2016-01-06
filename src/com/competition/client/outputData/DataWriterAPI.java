package com.competition.client.outputData;

import javax.xml.transform.stream.StreamResult;

/**
 * Created by Kestutis on 2016.01.03.
 */
public interface DataWriterAPI {
     StreamResult writeDataToStream(String outputPath);
}
