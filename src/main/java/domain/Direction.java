package domain;

import java.util.Objects;
import java.util.Random;

import static java.lang.Boolean.FALSE;

public class Direction {
    private static final String LADDER_LINE_NOT_OVERLAP_ERROR_MESSAGE = "[ERROR] 사다리 라인은 겹칠 수 없습니다.";

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);

        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LADDER_LINE_NOT_OVERLAP_ERROR_MESSAGE);
        }
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }

        return next(generatePoint());
    }

    private boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
