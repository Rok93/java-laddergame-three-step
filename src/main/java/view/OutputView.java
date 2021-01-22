package view;

import domain.*;
import dto.LadderResponseDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과\n";
    private static final String NAME_DELIMITER = "   ";
    private static final String RESULT_DELIMITER = "   ";
    private static final String LADDER_INITIAL_BLANK = "   ";
    private static final String LADDER_RIGHT_LINE_SYMBOL = "|-----";
    private static final String LADDER_LEFT_LINE_SYMBOL = "|     ";
    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER_COLON = " : ";

    private OutputView() {
    }

    public static void printLadderResult(LadderResponseDto responseDto) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printNames(responseDto.getNames());
        printLadder(responseDto.getLadderLines());
        printResults(responseDto.getResults());
    }

    private static void printNames(Names names) {
        List<Name> namesValues = names.getValues();
        String ladderParticipants = namesValues.stream()
                .map(Name::getValue)
                .collect(Collectors.joining(NAME_DELIMITER));

        System.out.println(ladderParticipants);
    }

    private static void printLadder(LadderLines ladderLines) {
        List<LadderLine> ladderLinesValues = ladderLines.getValues();
        ladderLinesValues.stream()
                .forEach(OutputView::printLadderLine);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        List<Point> points = ladderLine.getValues();
        System.out.print(LADDER_INITIAL_BLANK);
        String ladder = points.stream()
                .map(OutputView::convertPointToTemplate)
                .collect(Collectors.joining());

        System.out.println(ladder);
    }

    private static String convertPointToTemplate(Point point) {
        Direction direction = point.getDirection();
        if (direction.isRight()) {
            return LADDER_RIGHT_LINE_SYMBOL;
        }

        return LADDER_LEFT_LINE_SYMBOL;
    }

    private static void printResults(Results results) {
        List<Result> resultsValues = results.getValues();
        String ladderResults = resultsValues.stream()
                .map(Result::getValue)
                .collect(Collectors.joining(RESULT_DELIMITER));

        System.out.println(ladderResults + "\n");
    }

    public static void printResult(String result) {
        System.out.println(result + "\n");
    }

    public static void printAllResults(LadderResponseDto ladderAllResults) {
        Map<Name, Result> ladderResult = ladderAllResults.getLadderResult();
        System.out.println(PLAY_RESULT_MESSAGE);
        ladderResult.forEach((name, result) -> printEachResult(name, result));
    }

    private static void printEachResult(Name name, Result result) {
        System.out.println(name.getValue() + DELIMITER_COLON + result.getValue());
    }
}
