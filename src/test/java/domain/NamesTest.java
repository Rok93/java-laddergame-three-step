package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Names의 Name 수를 계산하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "A:B:C", "철수:영희:바둑이"
    }, delimiter = ':')
    void testCalculateNameNumber(String firstName, String secondName, String thirdName) {
        //given
        List<Name> nameValues = Arrays.asList(firstName, secondName, thirdName).stream()
                .map(Name::new)
                .collect(Collectors.toList());

        Names names = new Names(nameValues);

        //when
        int namesNumber = names.calculateNamesNumber();

        //then
        assertThat(namesNumber).isEqualTo(3);
    }

    @DisplayName("특정 사용자의 위치를 반환하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c:b:1", "철수,영희,바둑이:바둑이:2"
    }, delimiter = ':')
    void testFindNameSequence(String nameValues, String targetName, int expectedIndex) {
        //given
        Names names = new Names(Arrays.stream(nameValues.split(","))
                .map(Name::new)
                .collect(Collectors.toList()));

        //when
        int actualIndex = names.findNameSequence(targetName);

        //then
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @DisplayName("사용자의 위치를 반환하는 기능의 인자로 존재하지 않는 이름을 전달하면 예외를 발생시킨다")
    @Test
    void testFindNameSequenceIfFindNotExistName() {
        //given
        List<Name> nameValues = Arrays.asList(new Name("철수"), new Name("영희"), new Name("바둑이"));
        Names names = new Names(nameValues);

        String invalidateName = "땡칠이";

        //when //then
        assertThatThrownBy(() -> names.findNameSequence(invalidateName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
