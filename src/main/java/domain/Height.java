package domain;

public class Height {
    private static final String MIN_LADDER_HEIGHT_ERROR_MESSAGE = "[ERROR] 사다리의 높이는 최소 사다리의 높이보다 커야합니다.";
    private static final int MIN_LADDER_HEIGHT_LIMIT = 1;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_LADDER_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(MIN_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return height;
    }
}
