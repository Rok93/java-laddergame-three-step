package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 Point를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void testFirst(boolean isConnected, int expectedIndex) {
        //given
        Point first = Point.first(isConnected);

        //when
        int movedIndex = first.move();

        //then
        assertThat(movedIndex).isEqualTo(expectedIndex);
    }

    @DisplayName("Line에 연결된 선이 없을 때, next 기능을 테스트한다")
    @Test
    void testNextIfNotExistConnectedDirections() {
        //given
        Point second = Point.first(FALSE).next(FALSE);

        //when
        int movedIndex = second.move();

        //then
        assertThat(movedIndex).isEqualTo(1);
    }

    @DisplayName("Line의 연결된 선이 왼쪽 방향일 때, next 기능을 테스트한다")
    @Test
    void testNextIfExistLeftConnectedDirections() {
        //given
        Point second = Point.first(TRUE).next(FALSE);

        //when
        int movedIndex = second.move();

        //then
        assertThat(movedIndex).isEqualTo(0);
    }

    @DisplayName("Line의 연결된 선이 오른쪽 방향일 때, next 기능을 테스트한다")
    @Test
    void testNextIfExistRightConnectedDirections() {
        //given
        Point second = Point.first(FALSE).next(TRUE);

        //when
        int movedIndex = second.move();

        //then
        assertThat(movedIndex).isEqualTo(2);
    }

    @DisplayName("첫번째 Point가 연결되어있을 때, next기능을 테스트한다")
    @Test
    public void testNextIfBeforeLineIsConnected() {
        //given
        Point second = Point.first(TRUE).next();

        //when
        int movedIndex = second.move();

        //then
        assertThat(movedIndex).isEqualTo(0);
    }
}
