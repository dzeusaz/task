package com.competition.jUnit;

import com.competition.client.Constants;
import com.competition.client.ScoreCounter.CountRangeScoreEvent;
import org.junit.Test;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * Created by Kestutis on 2015.12.14.
 */
public class CountRangeScoreEventTest {

    @Test
    public void testCountScore() throws Exception {
        CountRangeScoreEvent range = new CountRangeScoreEvent();
        assertEquals( 900, (long) range.countScore(Constants.LONG_JUMP_A, Constants.LONG_JUMP_B, Constants.LONG_JUMP_C, 736));
        assertEquals( 900, (long) range.countScore(Constants.SHOT_PUT_A, Constants.SHOT_PUT_B, Constants.SHOT_PUT_C, 16.79));
        assertEquals( 896, (long) range.countScore(Constants.HIGH_JUMP_A, Constants.HIGH_JUMP_B, Constants.HIGH_JUMP_C, 210));
        assertEquals( 900, (long) range.countScore(Constants.DISCUS_THROW_A, Constants.DISCUS_THROW_B, Constants.DISCUS_THROW_C, 51.4));
        assertEquals( 898, (long) range.countScore(Constants.POLE_VAULT_A, Constants.POLE_VAULT_B, Constants.POLE_VAULT_C, 496));
        assertEquals( 900, (long) range.countScore(Constants.JAVELIN_THROW_A, Constants.JAVELIN_THROW_B, Constants.JAVELIN_THROW_C, 70.67));
    }
}