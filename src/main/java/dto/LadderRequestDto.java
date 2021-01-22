package dto;

import domain.Height;
import domain.Names;
import domain.Results;

public class LadderRequestDto {

    private Names names;
    private Results results;
    private Height height;

    public LadderRequestDto(Names names, Results results, Height height) {
        this.names = names;
        this.results = results;
        this.height = height;
    }

    public Height getHeight() {
        return height;
    }

    public int calculateParticipantsNumber() {
        return names.size();
    }

    public Results getResults() {
        return results;
    }

    public Names getNames() {
        return names;
    }
}
