package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @DisplayName("Direction 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitDirection() {
        //given
        boolean left = true;
        boolean right = false;

        //when
        Direction direction = Direction.of(left, right);

        //then
        assertAll(
                () -> assertThat(direction.isLeft()).isTrue(),
                () -> assertThat(direction.isRight()).isFalse()
        );
    }
}
