package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLinesTest {

    @DisplayName("LadderLines 일급 컬렉션을 생성하는 기능")
    @Test
    void testInitLadderLines() {
        //given
        Point first = Point.first(true);
        Point second = first.next(false);
        LadderLine ladderLine = new LadderLine(Arrays.asList(first, second));
        int height = 3;

        //when
        LadderLines ladderLines = new LadderLines(sizeOfPerson -> ladderLine, 2, height);

        //then
        assertThat(ladderLines.getValues()).extracting("points")
                .containsExactlyInAnyOrder(
                        Arrays.asList(first, second),
                        Arrays.asList(first, second),
                        Arrays.asList(first, second)
                );
    }


    @DisplayName("특정 인덱스의 결과 인덱스를 추적하는 기능을 테스트한다")
    @Test
    void testTraceResultIndexFrom() {
        //given
        Point first = Point.first(true);
        LadderLine ladderLine = new LadderLine(Arrays.asList(first, first.next(false)));
        int height = 3;

        //when
        LadderLines ladderLines = new LadderLines(sizeOfPerson -> ladderLine, 2, height);

        //then
        assertAll(
                () -> assertThat(ladderLines.traceResultIndexFrom(0)).isEqualTo(1),
                () -> assertThat(ladderLines.traceResultIndexFrom(1)).isEqualTo(0)
        );
    }
}
