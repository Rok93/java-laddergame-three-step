import controller.LadderGameController;
import domain.Height;
import domain.LadderLineDefaultStrategy;
import domain.Names;
import domain.Results;
import dto.LadderRequestDto;
import dto.LadderResponseDto;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LadderGame {
    private static final String END_COMMAND_ALL = "all";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        LadderGameController ladderGameController = new LadderGameController(new LadderLineDefaultStrategy());
        Names names = InputView.inputNames(scanner);
        Height height = InputView.inputHeight(scanner);
        Results results = InputView.inputResults(scanner);

        LadderRequestDto requestDto = new LadderRequestDto(names, results, height);
        LadderResponseDto responseDto = ladderGameController.play(requestDto);

        OutputView.printLadderResult(responseDto);

        String checkedPeople = InputView.inputRequestCheckedPeopleName(scanner);
        while (!checkedPeople.equals(END_COMMAND_ALL)) {
            LadderResponseDto ladderResultResponseDto = ladderGameController.checkResult(responseDto, checkedPeople);
            OutputView.printResult(ladderResultResponseDto.getResult());

            checkedPeople = InputView.inputRequestCheckedPeopleName(scanner);
        }

    }
}
