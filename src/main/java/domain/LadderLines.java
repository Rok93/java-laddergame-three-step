package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(LadderLineGenerateStrategy ladderLineGenerateStrategy, int personNumber, Height height) {
        this.ladderLines = new ArrayList<>();
        int heightValue = height.getValue();
        for (int i = 0; i < heightValue; i++) {
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
