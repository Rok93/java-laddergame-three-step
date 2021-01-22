package view;

import domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLEASE_INPUT_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLEASE_INPUT_LADDER_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HOW_MANY_HEIGHT_VALUE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String WHO_WANT_TO_SEE_MESSAGE = "결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static Names inputNames(Scanner scanner) {
        System.out.println(PLEASE_INPUT_PARTICIPANT_NAMES_MESSAGE);
        String nameValues = scanner.nextLine();
        List<Name> names = Arrays.stream(nameValues.split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());

        return new Names(names);
    }

    public static Results inputResults(Scanner scanner) {
        System.out.println(PLEASE_INPUT_LADDER_RESULTS_MESSAGE);
        String resultValues = scanner.nextLine();
        try {
            List<Result> results = Arrays.stream(resultValues.split(","))
                    .map(String::trim)
                    .map(Result::new)
                    .collect(Collectors.toList());

            return new Results(results);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputResults(scanner);
        }
    }

    public static Height inputHeight(Scanner scanner) {
        System.out.println(HOW_MANY_HEIGHT_VALUE_MESSAGE);
        try {
            return new Height(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight(scanner);
        }
    }

    public static String inputRequestCheckedPeopleName(Scanner scanner) {
        System.out.println(WHO_WANT_TO_SEE_MESSAGE);
        return scanner.nextLine();
    }
}
