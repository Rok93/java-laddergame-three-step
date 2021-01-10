package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitDirection() {
        //when
        Direction direction = Direction.of(true, false);

        //then
        assertThat(direction).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("Direction의 left, right 값이 겹치면 예외를 발생시킨다")
    @Test
    void testInitDirectionIfOverlapDirection() {
        //when //then
        assertThatThrownBy(() -> Direction.of(true, true))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
