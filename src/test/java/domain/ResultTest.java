package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @DisplayName("Result 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "보상A", "100,000원", "금"
    })
    void testInitResult(String resultValue) {
        //when
        Result result = new Result(resultValue);

        //then
        assertThat(result.getValue()).isEqualTo(resultValue);
    }

    @DisplayName("결괏값이 비어있는 경우, 예외를 발생시킨다")
    @ParameterizedTest
    @EmptySource
    void testInitResultIfResultValueIsEmpty(String resultValue) {
        //when //then
        assertThatThrownBy(() -> new Result(resultValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
