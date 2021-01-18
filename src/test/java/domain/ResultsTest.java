package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @DisplayName("Results 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitResults() {
        //given
        List<String> resultValues = Arrays.asList("a", "b", "c");

        List<Result> results = resultValues.stream()
                .map(Result::new)
                .collect(Collectors.toList());

        //when
        Results results2 = new Results(results);

        //then
        assertThat(results2.getValues())
                .usingElementComparatorOnFields("result")
                .containsExactlyInAnyOrder(new Result("a"), new Result("b"), new Result("c"));
    }
}
