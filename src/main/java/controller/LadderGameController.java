package controller;

import domain.LadderLineGenerateStrategy;
import domain.LadderLines;
import domain.Names;
import domain.Results;
import dto.LadderRequestDto;
import dto.LadderResponseDto;

public class LadderGameController {

    private final LadderLineGenerateStrategy ladderLineGenerateStrategy;

    public LadderGameController(LadderLineGenerateStrategy ladderLineGenerateStrategy) {
        this.ladderLineGenerateStrategy = ladderLineGenerateStrategy;
    }

    public LadderResponseDto play(LadderRequestDto requestDto) {
        LadderLines ladderLines = new LadderLines(
                ladderLineGenerateStrategy, requestDto.calculateParticipantsNumber(), requestDto.getHeight());

        return new LadderResponseDto(requestDto.getNames(), ladderLines, requestDto.getResults());
    }

    public LadderResponseDto checkResult(LadderResponseDto responseDto, String checkedPeople) {
        try {
            Names names = responseDto.getNames();
            LadderLines ladderLines = responseDto.getLadderLines();
            int resultIndex = ladderLines.traceResultIndexFrom(names.findNameSequence(checkedPeople));
            Results results = responseDto.getResults();
            return new LadderResponseDto(results.get(resultIndex).getValue());
        } catch (IllegalArgumentException e) {
            return new LadderResponseDto(e.getMessage());
        }
    }
}
