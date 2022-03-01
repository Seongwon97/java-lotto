package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {

    private final Map<Rank, Integer> prizeResult;

    public PrizeResult(List<Lotto> lottos, WinningNumbers winningNumber) {
        this.prizeResult = new HashMap<>();
        initFinalResult();
        calculatePrizeResult(lottos, winningNumber);
    }

    private void initFinalResult() {
        Rank.getWinnerPrices()
                .forEach(winnerPrice -> prizeResult.put(winnerPrice, 0));
    }

    private void calculatePrizeResult(List<Lotto> lottos, WinningNumbers winningNumber) {
        for (Lotto lotto : lottos) {
            final Rank winnerPrice = lotto.calculateRank(winningNumber);
            updatePrizeResult(winnerPrice);
        }
    }

    private void updatePrizeResult(Rank winnerPrice) {
        prizeResult.put(winnerPrice, prizeResult.get(winnerPrice) + 1);
    }

    public float earningRate(int inputMoney) {
        final float earningRate = (float) totalPrize() / inputMoney;
        return (float) (Math.floor(earningRate * 100) / 100.0);
    }

    private int totalPrize() {
        int totalPrice = 0;
        for (Rank winnerPrice : prizeResult.keySet()) {
            totalPrice += winnerPrice.getPrize() * prizeResult.get(winnerPrice);
        }
        return totalPrice;
    }

    public Map<Rank, Integer> getPrizeResult() {
        return Collections.unmodifiableMap(prizeResult);
    }

}
