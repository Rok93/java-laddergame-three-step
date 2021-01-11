package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("Name 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "가", "가나", "가나다", "가나다라", "가나다라마"
    })
    void testInitName(String nameValue) {
        //when
        Name name = new Name(nameValue);

        //then
        assertThat(name.getValue()).isEqualTo(nameValue);
    }

    @DisplayName("최대 이름길이 제한보다 이름의 길이가 길면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {
            "가나다라마바", "즐라탄 이브라히모비치", "아스필리쿠에타"
    })
    void testInitNameIfNameLengthLongerThanMaxNameLengthLimit(String nameValue) {
        //when //then
        assertThatThrownBy(() -> new Name(nameValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 이름길이 제한보다 이름의 길이가 짧으면 예외를 발생시킨다")
    @ParameterizedTest
    @EmptySource
    void testInitNameIfNameLengthShorterThanMinNameLengthLimit(String nameValue) {
        //when //then
        assertThatThrownBy(() -> new Name(nameValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
