package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Names {
    private static final int FIRST_INDEX = 0;
    private static final String NOT_EXIST_NAME_ERROR_MESSAGE = "[ERROR] 존재하지 않는 참가자입니다.";

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> getValues() {
        return Collections.unmodifiableList(names);
    }

    public int calculateNamesNumber() {
        return names.size();
    }


    public int findNameSequence(String targetName) {
        int nameSize = names.size();
        return IntStream.range(FIRST_INDEX, nameSize)
                .filter(index -> names.get(index).equalTo(targetName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_NAME_ERROR_MESSAGE));
    }
}
