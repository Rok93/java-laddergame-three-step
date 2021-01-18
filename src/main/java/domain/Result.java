package domain;

public class Result {
    private static final String NOT_EMPTY_RESULT_VALUE_ERROR_MESSAGE = "[ERROR] 결괏값은 빈 값을 입력할 수 없습니다.";

    private final String result;

    public Result(String result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(String result) {
        if (result.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_RESULT_VALUE_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return result;
    }
}
