package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumberTest {

    @Test
    @DisplayName("보너스 번호를 이미 갖고 있을 시 예외가 발생한다.")
    void checkBonusDuplicate_throwIllegalException() {
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        WinningNumber lotto = new WinningNumber(numbers);
        int bonus = 3;

        assertThatThrownBy(() -> lotto.addBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호가 당첨 번호와 중복됩니다.");
    }

}