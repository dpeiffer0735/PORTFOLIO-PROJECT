/**
 * {@code PlayerStatsTrackerKernel} enchanced with secondary methods
 */
public interface PlayerStatsTracker extends PlayerStatsTrackerKernel {

    /** Constant to check for Double/Triple Doubles. */
    int STAT_THRESHOLD = 10;

    /** Constant to check if player fouled out. */
    int FOUL_OUT_VALUE = 6;

    /** Constant for triple double calculation. */
    int TRIPLE_DOUBLE_CATEGORIES = 3;

    /**
     * Returns the players field goal percentage.
     *
     * @return fieldGoalsMade / fieldGoalsAttempted
     */
    double fieldGoalPercentage();

    /**
     * Returns if the player has a double double.
     *
     * @return true if a player has 2 stat categories >= 10
     */
    boolean hasDoubleDouble();

    /**
     * Returns if the player has a triple double.
     *
     * @return true if a player has 3 stat categories >= 10
     */
    boolean hasTripleDouble();

    /**
     * Returns if the player has fouled out.
     *
     * @return true if fouls >= FOUL_OUT_VALUE
     */
    boolean fouledOut();

    /**
     * Returns the players assist to turnover ratio.
     *
     * @return assists / turnovers
     */
    double assistToTurnoverRatio();
}
