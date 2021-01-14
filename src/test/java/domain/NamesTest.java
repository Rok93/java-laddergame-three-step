package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @DisplayName("Names 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "A:B:C", "철수:영희:바둑이"
    }, delimiter = ':')
    void testInitNames(String firstName, String secondName, String thirdName) {
        //given
        List<Name> nameValues = Arrays.asList(firstName, secondName, thirdName).stream()
                .map(Name::new)
                .collect(Collectors.toList());

        //when
        Names names = new Names(nameValues);

        //then
        assertThat(names.getValues())
                .extracting("name", String.class)
                .containsExactlyInAnyOrder(firstName, secondName, thirdName);
    }
}
