import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit tests for PlayerStatsTrackerKernel.
 */
public class PlayerStatsTrackerKernelTest {

    //Test initial state
    @Test
    public void testInitial() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();

        assertEquals(0, p.points());
        assertEquals(0, p.fieldGoalsMade());
        assertEquals(0, p.fieldGoalsAttempted());
        assertEquals(0, p.rebounds());
        assertEquals(0, p.assists());
        assertEquals(0, p.steals());
        assertEquals(0, p.blocks());
        assertEquals(0, p.fouls());
        assertEquals(0, p.turnovers());
    }

    //fieldGoalMade Tests
    @Test
    public void testFieldGoalMade() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);

        assertEquals(2, p.points());
        assertEquals(1, p.fieldGoalsMade());
        assertEquals(1, p.fieldGoalsAttempted());
    }

    @Test
    public void testFieldGoalMadeMultiple() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);
        p.fieldGoalMade(2);
        p.fieldGoalMade(3);

        assertEquals(7, p.points());
        assertEquals(3, p.fieldGoalsMade());
        assertEquals(3, p.fieldGoalsAttempted());
    }

    //fieldGoalMiss Tests
    @Test
    public void testFieldGoalMiss() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMiss();

        assertEquals(0, p.points());
        assertEquals(0, p.fieldGoalsMade());
        assertEquals(1, p.fieldGoalsAttempted());
    }

    @Test
    public void testFieldGoalMissMultiple() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMiss();
        p.fieldGoalMiss();
        p.fieldGoalMiss();

        assertEquals(0, p.points());
        assertEquals(0, p.fieldGoalsMade());
        assertEquals(3, p.fieldGoalsAttempted());
    }

    //Test multiple updating
    @Test
    public void testMultipleUpdate() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.fieldGoalMade(2);
        p.fieldGoalMade(3);
        p.fieldGoalMiss();
        p.recordRebound();
        p.recordAssist();

        assertEquals(5, p.points());
        assertEquals(2, p.fieldGoalsMade());
        assertEquals(3, p.fieldGoalsAttempted());
        assertEquals(1, p.rebounds());
        assertEquals(1, p.assists());
    }

    //Test all single stats
    @Test
    public void testAllStat() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordSteal();
        p.recordAssist();
        p.recordBlock();
        p.recordRebound();
        p.recordFoul();
        p.recordTurnover();

        assertEquals(1, p.steals());
        assertEquals(1, p.assists());
        assertEquals(1, p.blocks());
        assertEquals(1, p.rebounds());
        assertEquals(1, p.fouls());
        assertEquals(1, p.turnovers());
    }

    //Test multiple steal
    @Test
    public void testRecordMultipleSteal() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordSteal();
        p.recordSteal();
        p.recordSteal();

        assertEquals(3, p.steals());
    }

    //Test multiple assist
    @Test
    public void testRecordMultipleAssist() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordAssist();
        p.recordAssist();
        p.recordAssist();

        assertEquals(3, p.assists());
    }

    //Test multiple block
    @Test
    public void testRecordMultipleBlock() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordBlock();
        p.recordBlock();
        p.recordBlock();

        assertEquals(3, p.blocks());
    }

    //Test multiple rebound
    @Test
    public void testRecordMultipleRebound() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordRebound();
        p.recordRebound();
        p.recordRebound();

        assertEquals(3, p.rebounds());
    }

    //Test multiple foul
    @Test
    public void testRecordMultipleFoul() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordFoul();
        p.recordFoul();
        p.recordFoul();

        assertEquals(3, p.fouls());
    }

    //Test multiple turnover
    @Test
    public void testRecordMultipleTurnover() {
        PlayerStatsTracker p = new PlayerStatsTracker1L();
        p.recordTurnover();
        p.recordTurnover();
        p.recordTurnover();

        assertEquals(3, p.turnovers());
    }
}
