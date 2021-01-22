package dto;

import domain.*;

import java.util.HashMap;
import java.util.Map;

public class LadderResponseDto {

    private Names names;
    private LadderLines ladderLines;
    private Results results;
    private String result;
    private Map<Name, Result> ladderResult;

    public LadderResponseDto(Names names, LadderLines ladderLines, Results results) {
        this.names = names;
        this.ladderLines = ladderLines;
        this.results = results;
    }

    public LadderResponseDto(String result) {
        this.result = result;
    }

    public LadderResponseDto(Map<Name, Result> ladderResult) {
        this.ladderResult = new HashMap<>(ladderResult);
    }

    public Map<Name, Result> getLadderResult() {
        return ladderResult;
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
