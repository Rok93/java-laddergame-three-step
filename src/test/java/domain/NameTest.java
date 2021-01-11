package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("Name 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "가","가나","가나다", "가나다라", "가나다라마"
    })
    void testInitName(String nameValue) {
        //when
        Name name = new Name(nameValue);

        //then
        assertThat(name.getValue()).isEqualTo(nameValue);
    }
}
