/**
 * Simple demonstration of PlayerStatsTracker usage.
 */
public final class PlayerStatsDemo {

    /**
     * no instantiation.
     */
    private PlayerStatsDemo() {
    }

    /**
     * Simulates a players stats.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {

        PlayerStatsTracker player = new PlayerStatsTracker1L();

        // Simulate a basic game performance
        player.fieldGoalMade(2);
        player.fieldGoalMiss();
        player.fieldGoalMade(3);

        player.recordFoul();
        player.recordFoul();
        player.recordRebound();
        player.recordAssist();
        player.recordAssist();
        player.recordSteal();
        player.recordFoul();
        player.recordFoul();

        System.out.println("=== Player Game Summary ===");
        System.out.println(player);

        System.out.println("Field Goal %: " + player.fieldGoalPercentage());
        System.out
                .println("Assist/TO Ratio: " + player.assistToTurnoverRatio());
        System.out.println("Fouled Out : " + player.fouledOut());
    }
}
