/**
 * PlayerStatsTracker models a player's performance in a basketball game.
 */
public class PlayerStatsTracker {

    //Instance Variables
    private final String playerName;
    private int points;
    private int rebounds;
    private int assists;
    private int fouls;
    private int turnovers;
    private int blocks;
    private int steals;
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;

    private final int STAT_THRESHOLD = 10;
    private final int FOUL_OUT_VALUE = 6;
    private final int TRIPLE_DOUBLE_CATEGORIES = 3;
    private final int PERCENTAGE_CALCULATION = 100;
    private final int THREE_POINT_VALUE = 3;

    /**
     * Constructs a PlayerStatsTracker object for a given player.
     *
     * @param name
     *            the name of the player you want to track stats
     */
    public PlayerStatsTracker(String name) {
        this.playerName = name;
        this.points = 0;
        this.rebounds = 0;
        this.assists = 0;
        this.fouls = 0;
        this.turnovers = 0;
        this.blocks = 0;
        this.steals = 0;
        this.fieldGoalsMade = 0;
        this.fieldGoalsAttempted = 0;
    }

    //Kernels
    /**
     * Records a made field goal and records points.
     *
     * @param pts
     *            points to add
     */
    public void fieldGoalMade(int pts) {
        this.fieldGoalsMade++;
        this.fieldGoalsAttempted++;
        this.points += pts;
    }

    /**
     * Records a missed field goal.
     */
    public void fieldGoalMiss() {
        this.fieldGoalsAttempted++;
    }

    /**
     * Records a rebound.
     */
    public void recordRebound() {
        this.rebounds++;
    }

    /**
     * Records an assist.
     */
    public void recordAssist() {
        this.assists++;
    }

    /**
     * Records a foul.
     */
    public void recordFoul() {
        this.fouls++;
    }

    /**
     * Records a turnover.
     */
    public void recordTurnover() {
        this.turnovers++;
    }

    /**
     * Records a block.
     */
    public void recordBlock() {
        this.blocks++;
    }

    /**
     * Records a steal.
     */
    public void recordSteal() {
        this.steals++;
    }

    //Getter
    /**
     * Returns number of points scored.
     *
     * @return players current points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Returns number of rebounds.
     *
     * @return players current rebounds
     */
    public int getRebounds() {
        return this.rebounds;
    }

    /**
     * Returns number of assists.
     *
     * @return players current assists
     */
    public int getAssists() {
        return this.assists;
    }

    /**
     * Returns number of fouls.
     *
     * @return players current fouls
     */
    public int getFouls() {
        return this.fouls;
    }

    /**
     * Returns number of turnovers.
     *
     * @return players current turnovers
     */
    public int getTurnovers() {
        return this.turnovers;
    }

    /**
     * Returns number of blocks.
     *
     * @return players current blocks
     */
    public int getBlocks() {
        return this.blocks;
    }

    /**
     * Returns number of steals.
     *
     * @return players current steals
     */
    public int getSteals() {
        return this.steals;
    }

    /**
     * Returns the players name.
     *
     * @return players name
     */
    public String getPlayerName() {
        return this.playerName;
    }

    //Secondary
    /**
     * Returns whether or not the player has 6 or more fouls.
     *
     * @return fouls >= 6
     */
    public boolean fouledOut() {
        return this.fouls >= this.FOUL_OUT_VALUE;
    }

    /**
     * Returns the players ratio between assists and turnovers.
     *
     * @return assist / turnovers
     */
    public double assistToTurnoverRatio() {
        double ratio = (double) this.assists;
        if (this.turnovers != 0) {
            ratio /= (double) this.turnovers;
        }
        return ratio;
    }

    /**
     * Returns the players ratio between made field goals and attempted.
     *
     * @return fieldGoalsMade / fieldGoalsAttempted
     */
    public double fieldGoalPercentage() {
        double percentage = 0.0;
        if (this.fieldGoalsAttempted != 0) {
            percentage = (double) this.fieldGoalsMade
                    / this.fieldGoalsAttempted;
        }
        return percentage;
    }

    /**
     * Counts how many stats are ten for double and triple double methods.
     *
     * @return total amount of stat categories with 10
     */
    public int howManyStatsTen() {
        int total = 0;
        if (this.points >= this.STAT_THRESHOLD) {
            total++;
        }
        if (this.rebounds >= this.STAT_THRESHOLD) {
            total++;
        }
        if (this.assists >= this.STAT_THRESHOLD) {
            total++;
        }
        if (this.steals >= this.STAT_THRESHOLD) {
            total++;
        }
        if (this.blocks >= this.STAT_THRESHOLD) {
            total++;
        }
        return total;
    }

    /**
     * Returns whether the player has a double double.
     *
     * @return if the player has 2 categories with 10+
     */
    public boolean hasDoubleDouble() {
        return this.howManyStatsTen() >= 2;
    }

    /**
     * Returns whether the player has a triple double.
     *
     * @return if the player has 3 categories with 10+
     */
    public boolean hasTripleDouble() {
        return this.howManyStatsTen() >= this.TRIPLE_DOUBLE_CATEGORIES;
    }

    //Demo
    /**
     * Simulates a players stats.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String args[]) {
        PlayerStatsTracker mobley = new PlayerStatsTracker("Evan Mobley");
        //Simulate Stats (can be made into a gui with buttons)
        mobley.fieldGoalMade(mobley.THREE_POINT_VALUE);
        mobley.fieldGoalMade(mobley.THREE_POINT_VALUE);
        mobley.fieldGoalMade(2);
        mobley.fieldGoalMiss();
        mobley.fieldGoalMiss();
        mobley.recordRebound();
        mobley.recordRebound();
        mobley.recordRebound();
        mobley.recordAssist();
        mobley.recordBlock();
        mobley.recordBlock();
        mobley.recordFoul();
        mobley.recordSteal();
        mobley.recordTurnover();

        //Print Stat Results
        System.out.println("Player: " + mobley.getPlayerName());
        System.out.println("Points: " + mobley.getPoints());
        System.out.println("Field Goal %: "
                + mobley.fieldGoalPercentage() * mobley.PERCENTAGE_CALCULATION
                + "%");
        System.out.println(
                "Assist / Turnover Ratio: " + mobley.assistToTurnoverRatio());
        System.out.println("Has Double Double: " + mobley.hasDoubleDouble());
        System.out.println("Has Triple Double: " + mobley.hasTripleDouble());
        System.out.println("Fouled Out: " + mobley.fouledOut());

    }
}
