package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("같은 숫자를 가진 로또 넘버 객체는 동일하다.")
    void lottoNumberEqual() {
        LottoNumber lottoNumber1 = new LottoNumber(12);
        LottoNumber lottoNumber2 = new LottoNumber(12);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

}