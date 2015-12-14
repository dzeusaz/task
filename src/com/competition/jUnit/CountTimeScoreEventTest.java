package com.competition.jUnit;

import com.competition.client.Constants;
import com.competition.client.ScoreCounter.CountTimeScoreEvent;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kestutis on 2015.12.14.
 */
public class CountTimeScoreEventTest {

    @Test
    public void testCountScore() throws Exception {
        CountTimeScoreEvent time = new CountTimeScoreEvent();
        assertEquals( 900, (long) time.countScore(Constants.RUN_100_METRES_A, Constants.RUN_100_METRES_B, Constants.RUN_100_METRES_C, 10.827));
        assertEquals( 900, (long) time.countScore(Constants.RUN_400_METRES_A, Constants.RUN_400_METRES_B, Constants.RUN_400_METRES_C, 48.19));
        assertEquals( 900, (long) time.countScore(Constants.RUN_110_METRES_A, Constants.RUN_110_METRES_B, Constants.RUN_110_METRES_C, 14.59));
        assertEquals( 900, (long) time.countScore(Constants.RUN_1500_METRES_A, Constants.RUN_1500_METRES_B, Constants.RUN_1500_METRES_C, 247.42));

    }
}