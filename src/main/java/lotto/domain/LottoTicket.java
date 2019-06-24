package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;
import static lotto.view.ConsoleOutPutView.NEW_LINE;

public class LottoTicket {
    private int numberOfCustomLotto;
    private int numberOfAutoLotto;
    private final List<Lotto> lottos;

    public LottoTicket(NumberOfCustomLotto customAmount, List<String> customLottos) {
        this.numberOfCustomLotto = customAmount.getNumberOfCustomLotto();
        this.numberOfAutoLotto = customAmount.getNumberOfAutoLotto();
        this.lottos = new ArrayList<>();

        createCustomLottoNumbers(customLottos);
        createAutoLottoNumbers();
    }

    private void createCustomLottoNumbers(List<String> customLottos) {
        for (int i = 0; i < numberOfCustomLotto; i++) {
            lottos.add(new CustomGenerateLotto(customLottos.get(i)));
        }
    }

    private void createAutoLottoNumbers() {
        for (int i = 0; i < numberOfAutoLotto; i++) {
            lottos.add(new AutoGenerateLottoNumbers());
        }
    }

    public int getNumberOfAutoLotto() {
        return numberOfAutoLotto;
    }

    public int getNumberOfCustomLotto() {
        return numberOfCustomLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> matchLotto(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        lottos.stream().forEach(lotto -> ranks.add(Rank.valueOf(lotto.numberOfMatch(winningLotto.getWinningNumbers())
                , lotto.bonusOfMatch(winningLotto.getBonusBall()))));

        return ranks;
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(joining(NEW_LINE));
    }

}