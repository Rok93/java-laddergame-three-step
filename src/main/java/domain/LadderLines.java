package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(LadderLineGenerateStrategy ladderLineGenerateStrategy, int personNumber, int height) {
        this.ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.ladderLines.add(ladderLineGenerateStrategy.generateLine(personNumber));
        }
    }

    public int traceResultIndexFrom(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.move(index);
        }

        return index;
    }

    protected List<LadderLine> getValues() {
        return Collections.unmodifiableList(ladderLines);
    }
}
