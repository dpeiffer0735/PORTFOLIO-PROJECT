/**
 * Kernel implementation of the PlayerStatsTracker.
 *
 * <p>This implementation represents the statistical performance of a single
 * basketball player during a game using integer fields. Each field
 * stores a specific statistic such as points, rebounds, assists, steals,
 * blocks, fouls, turnovers, and field goal attempts/makes.
 *
 * <p>This representation is chosen because it directly models the real-world
 * statistics being tracked and allows constant-time updates and access to each
 * statistic.
 *
 * CONVENTION:
 * All stat fields are non-negative integers.
 * No field is ever negative.
 *
 * CORRESPONDENCE:
 * points represents total points scored by the player.
 * fieldGoalsMade represents successful field goals.
 * fieldGoalsAttempted represents all shot attempts.
 * rebounds, assists, steals, blocks, fouls, and turnovers
 * represent their same game stats.
 */
public class PlayerStatsTracker1L extends PlayerStatsTrackerSecondary {

    /**
     * Total points scored by the player.
     */
    private int points = 0;
    /**
     * Total field goals made by the player.
     */
    private int fieldGoalsMade = 0;
    /**
     * Total field goals attempted by the player.
     */
    private int fieldGoalsAttempted = 0;
    /**
     * Total rebounds by the player.
     */
    private int rebounds = 0;
    /**
     * Total assists by the player.
     */
    private int assists = 0;
    /**
     * Total steals by the player.
     */
    private int steals = 0;
    /**
     * Total blocks by the player.
     */
    private int blocks = 0;
    /**
     * Total fouls by the player.
     */
    private int fouls = 0;
    /**
     * Total turnovers by the player.
     */
    private int turnovers = 0;

    /**
     * Constructs a new PlayerStatsTracker object with all stats initialized to 0.
     *
     * @ensures all stats (points, fieldGoalsMade, fieldGoalsAttempted, rebounds,
     * assists, steals, blocks, fouls, turnovers) = 0
     */
    public PlayerStatsTracker1L() {
        //all fields already start at 0.
    }

    /**
     * Records a made field goal.
     *
     * @param pts the points scored
     * @requires pts >= 0
     * @updates this
     * @ensures points = #points + pts
     *          and fieldGoalsMade = #fieldGoalsMade + 1
     *          and fieldGoalsAttempted = #fieldGoalsAttempted + 1
     */
    public void fieldGoalMade(int pts) {
        points += pts;
        fieldGoalsMade++;
        fieldGoalsAttempted++;
    }

    /**
     * Records a missed field goal.
     *
     * @updates this
     * @ensures fieldGoalsAttempted = #fieldGoalsAttempted + 1
     */
    public void fieldGoalMiss() {
        fieldGoalsAttempted++;
    }

    /**
     * Records a rebound.
     *
     * @updates this
     * @ensures rebounds = #rebounds + 1
     */
    public void recordRebound() {
        rebounds++;
    }

    /**
     * Records an assist.
     *
     * @updates this
     * @ensures assists = #assists + 1
     */
    public void recordAssist() {
        assists++;
    }

    /**
     * Records a steal.
     *
     * @updates this
     * @ensures steals = #steals + 1
     */
    public void recordSteal() {
        steals++;
    }

    /**
     * Records a block.
     *
     * @updates this
     * @ensures blocks = #blocks + 1
     */
    public void recordBlock() {
        blocks++;
    }

    /**
     * Records a foul.
     *
     * @updates this
     * @ensures fouls = #fouls + 1
     */
    public void recordFoul() {
        fouls++;
    }

    /**
     * Records a turnover.
     *
     * @updates this
     * @ensures turnovers = #turnovers + 1
     */
    public void recordTurnover() {
        turnovers++;
    }

    /**
     * Returns the number of points.
     *
     * @return the number of points
     * @ensures points = #points
     */
    public int points() {
        return points;
    }

    /**
     * Returns the number of fieldGoalsMade.
     *
     * @return the number of fieldGoalsMade
     * @ensures fieldGoalsMade = #fieldGoalsMade
     */
    public int fieldGoalsMade() {
        return fieldGoalsMade;
    }

    /**
     * Returns the number of fieldGoalsAttempted.
     *
     * @return the number of fieldGoalsAttempted
     * @ensures fieldGoalsAttempted = #fieldGoalsAttempted
     */
    public int fieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    /**
     * Returns the number of rebounds.
     *
     * @return the number of rebounds
     * @ensures rebounds = #rebounds
     */
    public int rebounds() {
        return rebounds;
    }

    /**
     * Returns the number of assists.
     *
     * @return the number of assists
     * @ensures assists = #assists
     */
    public int assists() {
        return assists;
    }

    /**
     * Returns the number of steals.
     *
     * @return the number of steals
     * @ensures steals = #steals
     */
    public int steals() {
        return steals;
    }

    /**
     * Returns the number of blocks.
     *
     * @return the number of blocks
     * @ensures blocks = #blocks
     */
    public int blocks() {
        return blocks;
    }

    /**
     * Returns the number of fouls.
     *
     * @return the number of fouls
     * @ensures fouls = #fouls
     */
    public int fouls() {
        return fouls;
    }

    /**
     * Returns the number of turnovers.
     *
     * @return the number of turnovers
     * @ensures turnovers = #turnovers
     */
    public int turnovers() {
        return turnovers;
    }
}