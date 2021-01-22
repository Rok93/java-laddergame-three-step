package dto;

import domain.LadderLines;
import domain.Names;
import domain.Results;

public class LadderResponseDto {

    private Names names;
    private LadderLines ladderLines;
    private Results results;
    private String result;

    public LadderResponseDto(Names names, LadderLines ladderLines, Results results) {
        this.names = names;
        this.ladderLines = ladderLines;
        this.results = results;
    }

    public LadderResponseDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Names getNames() {
        return names;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }

    public Results getResults() {
        return results;
    }
}
