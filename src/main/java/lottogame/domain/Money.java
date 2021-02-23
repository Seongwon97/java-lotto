package lottogame.domain;

import lottogame.utils.InvalidMoneyException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return this.money;
    }

    public int lottoQuantity() {
        return this.money / LOTTO_PRICE;
    }

    private void validate(String money) {
        if (!NUMBER_PATTERN.matcher(money).matches()) {
            throw new InvalidMoneyException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}