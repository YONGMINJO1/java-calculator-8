package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    // TDD 테스트
    @Test
    void 빈_문자열_입력시_0을_반환한다() {

        String input = "";

        int result = StringAddCalculator.add(input);

        assertThat(result).isEqualTo(0);

    }

    @Test
    void null_문자열_입력시_0을_반환한다() {

        String input = null;

        int result = StringAddCalculator.add(input);

        assertThat(result).isEqualTo(0);

    }

    @Test
    void 쉼표로_구분된_숫자를_더한다() {

        String input = "1,2,3";

        int result = StringAddCalculator.add(input);

        assertThat(result).isEqualTo(6);

    }

    @Test
    void 콜론으로_구분된_숫자를_더한다() {

        String input = "1,2:3";

        int result = StringAddCalculator.add(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자로_숫자를_더한다() {

        String input = "//;\n1;2;3";

        int result = StringAddCalculator.add(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수가_포함된_입력값이_들어오면_예외를_던진다() {

        String input = "1,-2,3";

        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                        StringAddCalculator.add(input)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다:");
    }
}
