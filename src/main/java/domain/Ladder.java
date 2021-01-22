package domain;

public class Ladder {
    private static final int FIRST_INDEX = 0;

    private final LadderLines ladderLines;

    public Ladder(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}
