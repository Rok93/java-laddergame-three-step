package domain;

public class Name {
    private static final int MAX_NAME_LENGTH_LIMIT = 5;
    private static final String NOT_SATISFIED_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 참가자의 이름은 최소 1글자 이상 5글자 이하만 가능합니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NOT_SATISFIED_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return name;
    }
}
