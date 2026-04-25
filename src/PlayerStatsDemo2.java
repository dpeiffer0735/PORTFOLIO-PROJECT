/**
 * Demonstration of PlayerStatsTracker that is more game accurate.
 */
public final class PlayerStatsDemo2 {

    /**
     * no instantiation.
     */
    private PlayerStatsDemo2() {
    }

    /**
     * Simulates a players stats.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {

        PlayerStatsTracker lebron = new PlayerStatsTracker1L();

        // First quarter
        lebron.fieldGoalMade(2);
        lebron.fieldGoalMiss();
        lebron.recordRebound();
        lebron.recordAssist();
        lebron.recordSteal();

        // Second quarter
        lebron.fieldGoalMade(3);
        lebron.fieldGoalMade(2);
        lebron.recordAssist();
        lebron.fieldGoalMiss();
        lebron.recordFoul();
        lebron.recordAssist();
        lebron.recordBlock();
        lebron.recordFoul();

        // Third quarter
        lebron.fieldGoalMade(2);
        lebron.recordAssist();
        lebron.recordBlock();
        lebron.fieldGoalMiss();
        lebron.recordFoul();

        // Fourth quarter
        lebron.fieldGoalMade(2);
        lebron.fieldGoalMade(2);
        lebron.fieldGoalMade(2);
        lebron.fieldGoalMiss();
        lebron.fieldGoalMiss();
        lebron.fieldGoalMiss();
        lebron.recordRebound();

        System.out.println("=== Final Game Stats ===");
        System.out.println(lebron);
        System.out.println("FG%: " + lebron.fieldGoalPercentage());
        System.out.println("Double Double? " + lebron.hasDoubleDouble());
        System.out.println("Triple Double? " + lebron.hasTripleDouble());
        System.out.println("Fouled Out? " + lebron.fouledOut());
    }
}
