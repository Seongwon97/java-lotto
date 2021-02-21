package lotto.domain.lottos;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String NULL_ERROR_MESSAGE = "null값은 허용하지 않습니다.";
    public static final String EMPTY_ERROR_MESSAGE = "숫자는 하나 이상이어야 합니다.";
    public static final String COUNT_ERROR_MESSAGE = "숫자는 %d개 여야 합니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 존재합니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, NULL_ERROR_MESSAGE);
        validateLottoTicket(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isContain(final int number) {
        return this.lottoNumbers.contains(new LottoNumber(number));
    }

    private void validateLottoTicket(final List<LottoNumber> lottoNumbers) {
        validateEmptyTicket(lottoNumbers);
        validateCount(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    private void validateEmptyTicket(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateCount(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() == LOTTO_NUMBER_SIZE) {
            return;
        }
        throw new IllegalArgumentException(String.format(COUNT_ERROR_MESSAGE, LOTTO_NUMBER_SIZE));
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}