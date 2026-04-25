/**
 * Secondary implementation of PlayerStatsTracker.
 *
 * <p>
 * This class implements all secondary methods only using
 * PlayerStatsTrackerKernel methods.
 * </p>
 */
public abstract class PlayerStatsTrackerSecondary
        implements PlayerStatsTracker {

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        return "PTS: " + points() + ", REB: " + rebounds() + ", AST: "
                + assists() + ", STL: " + steals() + ", BLK: " + blocks()
                + ", TO: " + turnovers() + ", FLS: " + fouls() + ", FG% "
                + this.fieldGoalPercentage();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        PlayerStatsTracker other = (PlayerStatsTracker) o;

        return points() == other.points() && rebounds() == other.rebounds()
                && assists() == other.assists() && steals() == other.steals()
                && blocks() == other.blocks()
                && turnovers() == other.turnovers() && fouls() == other.fouls()
                && Double.compare(this.fieldGoalPercentage(),
                        other.fieldGoalPercentage()) == 0;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double fieldGoalPercentage() {
        double percent = 0.0;
        if (fieldGoalsAttempted() != 0) {
            percent = (double) fieldGoalsMade() / fieldGoalsAttempted()
                    * PERCENTAGE_CALCULATION;
        }
        return percent;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean hasDoubleDouble() {
        int tenPlus = 0;
        if (points() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (rebounds() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (assists() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (steals() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (blocks() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        return tenPlus >= 2;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean hasTripleDouble() {
        int tenPlus = 0;
        if (points() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (rebounds() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (assists() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (steals() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        if (blocks() >= STAT_THRESHOLD) {
            tenPlus++;
        }
        return tenPlus >= TRIPLE_DOUBLE_CATEGORIES;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean fouledOut() {
        return fouls() >= FOUL_OUT_VALUE;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double assistToTurnoverRatio() {
        double ratio = assists();
        if (turnovers() != 0) {
            ratio = (double) assists() / turnovers();
        }
        return ratio;
    }
}
