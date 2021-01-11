package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
}
