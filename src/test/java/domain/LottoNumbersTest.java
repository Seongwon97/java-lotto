package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("올바른 크기의 로또 생성")
    void createLotto_makeRightLotto() {
        Integer[] numbersArray = {1, 2, 3, 4, 5, 6};
        List<Integer> numbers = Arrays.asList(numbersArray);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

}