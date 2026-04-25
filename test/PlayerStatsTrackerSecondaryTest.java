import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for PlayerStatsTrackerSecondary.
 */
public class PlayerStatsTrackerSecondaryTest {
    //fieldGoalPercentage Tests
    @Test
    public void testFieldGoalPercentageFifty() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);
        p.fieldGoalMade(2);
        p.fieldGoalMiss();
        p.fieldGoalMiss();

        assertEquals(50.0, p.fieldGoalPercentage(), 0.01);
    }

    @Test
    public void testFieldGoalPercentageZero() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMiss();
        p.fieldGoalMiss();

        assertEquals(0.0, p.fieldGoalPercentage(), 0.01);
    }

    @Test
    public void testFieldGoalPercentagePerfect() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);
        p.fieldGoalMade(2);

        assertEquals(100.0, p.fieldGoalPercentage(), 0.01);
    }

    //hasDoubleDouble Tests
    @Test
    public void testHasDoubleDoubleTrue() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 10; i++) {
            p.recordRebound();
            p.recordAssist();
        }

        assertTrue(p.hasDoubleDouble());
    }

    @Test
    public void testHasDoubleDoubleFalse() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordRebound();
        p.recordAssist();

        assertFalse(p.hasDoubleDouble());
    }

    //hasTripleDouble Tests
    @Test
    public void testHasTripleDoubleTrue() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 10; i++) {
            p.recordAssist();
            p.recordRebound();
            p.recordBlock();
        }

        assertTrue(p.hasTripleDouble());
    }

    @Test
    public void testHasTripleDoubleFalse() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordAssist();
        p.recordRebound();
        p.recordBlock();

        assertFalse(p.hasTripleDouble());
    }

    //fouledOut Tests
    @Test
    public void testFouledOutTrue() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 6; i++) {
            p.recordFoul();
        }

        assertTrue(p.fouledOut());
    }

    @Test
    public void testFouledOutFalse() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 5; i++) {
            p.recordFoul();
        }

        assertFalse(p.fouledOut());
    }

    //assistToTurnoverRatio Tests
    @Test
    public void testAssistToTurnoverRatioDouble() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 8; i++) {
            p.recordAssist();
        }
        for (int i = 0; i < 4; i++) {
            p.recordTurnover();
        }

        assertEquals(2.0, p.assistToTurnoverRatio(), 0.01);
    }

    @Test
    public void testAssistToTurnoverRatioNoTurnovers() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 5; i++) {
            p.recordAssist();
        }

        assertEquals(5.0, p.assistToTurnoverRatio(), 0.01);
    }

    @Test
    public void testAssistToTurnoverRatioNoAssists() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        for (int i = 0; i < 5; i++) {
            p.recordTurnover();
        }

        assertEquals(0.0, p.assistToTurnoverRatio(), 0.01);
    }

    //toString Test
    @Test
    public void testToStringContainsStats() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);
        p.recordRebound();
        p.recordAssist();
        String s = p.toString();

        assertTrue(s.contains("PTS"));
        assertTrue(s.contains("REB"));
        assertTrue(s.contains("AST"));
    }

    //equals Test
    @Test
    public void testEqualsSameObject() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();

        assertTrue(p.equals(p));
    }

    @Test
    public void testEqualsTrue() {
        PlayerStatsTracker p1 = new PlayerStatsTracker1L();
        PlayerStatsTracker p2 = new PlayerStatsTracker1L();
        p1.fieldGoalMade(2);
        p2.fieldGoalMade(2);

        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsFalse() {
        PlayerStatsTracker p1 = new PlayerStatsTracker1L();
        PlayerStatsTracker p2 = new PlayerStatsTracker1L();
        p1.fieldGoalMade(2);

        assertFalse(p1.equals(p2));
    }
}
