import components.standard.Standard;
/**
 * PlayerStatsTrackerKernel models the core operations to track a basketball
 * player's statistics during a game.
 *
 * <p>
 * A PlayerStatsTrackerKernel object represents the statistical performance of a
 * basketball player including points, rebounds, assists, steals, blocks,
 * turnovers, fouls, and field goal makes/attempts.
 * </p>
 *
 * <p>
 * The kernel interface provides the methods needed for a minimal set of
 * operations required to update and a players basic stats
 * </p>
 */
public interface PlayerStatsTrackerKernel extends Standard<PlayerStatsTracker> {

    /**
     * Records a made field goal and adds points to the player's statistics.
     *
     * @param pts
     *            points to add
     * @updates this
     * @requires pts >= 0
     * @ensures this.points = #this.points + pts
     *      AND this.fieldGoalsMade = #this.fieldGoalsMade + 1
     *      AND this.fieldGoalsAttempted = #this.fieldGoalsAttempted + 1
     */
    void fieldGoalMade(int pts);

    /**
     * Records a field goal attempt for a player.
     *
     * @updates this
     * @ensures this.fieldGoalsAttempted = #this.fieldGoalsAttempted + 1
     */
    void fieldGoalMiss();

    /**
     * Records a rebound for a player.
     *
     * @updates this
     * @ensures this.rebounds = #this.rebounds + 1
     */
    void recordRebound();

    /**
     * Records an assist for a player.
     *
     * @updates this
     * @ensures this.assists = #this.assists + 1
     */
    void recordAssist();

    /**
     * Records a foul for a player.
     *
     * @updates this
     * @ensures this.fouls = #this.fouls + 1
     */
    void recordFoul();

    /**
     * Records a turnover for a player.
     *
     * @updates this
     * @ensures this.turnovers = #this.turnovers + 1
     */
    void recordTurnover();

    /**
     * Records a block for a player.
     *
     * @updates this
     * @ensures this.blocks = #this.blocks + 1
     */
    void recordBlock();

    /**
     * Records a steal for a player.
     *
     * @updates this
     * @ensures this.steals = #this.steals + 1
     */
    void recordSteal();

    /**
     * Returns the number of points.
     *
     * @return current points
     */
    int points();

    /**
     * Returns the number of rebounds.
     *
     * @return current rebounds
     */
    int rebounds();

    /**
     * Returns the number of assists.
     *
     * @return current assists
     */
    int assists();

    /**
     * Returns the number of steals.
     *
     * @return current steals
     */
    int steals();

    /**
     * Returns the number of blocks.
     *
     * @return current blocks
     */
    int blocks();

    /**
     * Returns the number of fouls.
     *
     * @return current fouls
     */
    int fouls();

    /**
     * Returns the number of turnovers.
     *
     * @return current turnovers
     */
    int turnovers();

    /**
     * Returns the number of field goals made.
     *
     * @return field goals made
     */
    int fieldGoalsMade();

    /**
     * Returns the number of field goals attempted.
     *
     * @return field goals attempted
     */
    int fieldGoalsAttempted();
}
