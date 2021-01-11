package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @DisplayName("Height 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8
    })
    void testInitHeight(int heightValue) {
        //when
        Height height = new Height(heightValue);

        //then
        assertThat(height.getValue()).isEqualTo(heightValue);
    }

    @DisplayName("Height가 최소 높이보다 작으면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {
            -8, -7, -6, -5, -4, -3, -2, -1, 0
    })
    void testInitHeightIfHeightValueLessThanMinHeight(int heightValue) {
        //when //then
        assertThatThrownBy(() -> new Height(heightValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
