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

    protected List<LadderLine> getValues() {
        return Collections.unmodifiableList(ladderLines);
    }
}
