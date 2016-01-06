package com.competition.client.outputData;

import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Kestutis on 2016.01.03.
 */
public class WriteDataToStreamAPI implements DataWriterAPI {

    @Override
    public StreamResult writeDataToStream(String outputPath) {
        StreamResult result = new StreamResult(new File(outputPath));
        return result;
    }
}
