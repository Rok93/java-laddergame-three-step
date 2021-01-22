package controller;

import domain.*;
import dto.LadderRequestDto;
import dto.LadderResponseDto;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameController {

    public static final int FIRST_INDEX = 0;
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

    public LadderResponseDto checkAllResult(LadderResponseDto responseDto) {
        Names names = responseDto.getNames();
        LadderLines ladderLines = responseDto.getLadderLines();
        Results results = responseDto.getResults();

        int peopleNumber = names.calculateNamesNumber();
        Map<Name, Result> ladderResult = IntStream.range(FIRST_INDEX, peopleNumber)
                .mapToObj(Integer::new)
                .collect(Collectors.toMap(names::get, index -> results.get(ladderLines.traceResultIndexFrom(index))));
        return new LadderResponseDto(ladderResult);
    }
}
