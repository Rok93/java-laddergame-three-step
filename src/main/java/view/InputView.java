package view;

import domain.Name;
import domain.Names;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLEASE_INPUT_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static Names inputNames(Scanner scanner) {
        System.out.println(PLEASE_INPUT_PARTICIPANT_NAMES_MESSAGE);
        String nameValues = scanner.nextLine();
        List<Name> names = Arrays.stream(nameValues.split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());

        return new Names(names);
    }
}
