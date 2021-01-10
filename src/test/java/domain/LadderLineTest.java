package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLineTest {

    @DisplayName("LadderLine 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitLadderLine() {
        //given
        Point first = Point.first(true);
        Point second = first.next(false);
        List<Point> points = Arrays.asList(first, second);

        //when
        LadderLine ladderLine = new LadderLine(points);

        //then
        assertAll(
                () -> assertThat(ladderLine.move(0)).isEqualTo(1),
                () -> assertThat(ladderLine.move(1)).isEqualTo(0)
        );
    }
}
