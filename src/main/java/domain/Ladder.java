package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int FIRST_INDEX = 0;

    private final LadderLines ladderLines;

    public Ladder(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }

    public List<Integer> play(int personNumber) {
        return IntStream.range(FIRST_INDEX, personNumber)
                .mapToObj(ladderLines::traceResultIndexFrom)
                .collect(Collectors.toList());
    }
}
