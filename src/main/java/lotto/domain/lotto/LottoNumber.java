package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL;

    static {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        LOTTO_NUMBER_POOL = Collections.unmodifiableList(lottoNumbers);
    }

    private final int lottoNumber;

    private LottoNumber(int number) {
        checkRange(number);
        this.lottoNumber = number;
    }

    private static void checkRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException("로또 번호의 범위에 벗어납니다.");
        }
    }

    public static LottoNumber of(int number) {
        checkRange(number);
        return LOTTO_NUMBER_POOL.get(number - 1);
    }

    public static LottoNumber of(String numberText) {
        try {
            return of(Integer.parseInt(numberText));
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumberException("로또 번호는 숫자만 가능합니다.");
        }
    }

    public int getNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber - o.lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}