package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리를 만드는 기능을 테스트한다")
    @Test
    void testInitLadder() {
        //given
        Point first = Point.first(true);
        Point second = first.next(false);
        Height height = new Height(2);
        LadderLineGenerateStrategy ladderLineGenerateStrategy = number -> new LadderLine(Arrays.asList(first, second));

        LadderLines ladderLines = new LadderLines(ladderLineGenerateStrategy, 2, height);

        //when
        Ladder ladder = new Ladder(ladderLines);

        //then
        assertThat(ladder.getLadderLines()).isEqualTo(ladderLines);
    }
}
