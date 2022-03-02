package domain;

public class Money {

    private static final String ERROR_PRICE_NON_INTEGER = "가격은 정수만 가능합니다.";
    private static final String ERROR_LESS_THAN_MINIMUM_PRICE = "가격은 1000원 이상만 가능합니다.";
    private static final int LOTTO_PRICE = 1000;

    private int money;

    public Money(final String money) {
        this.money = validatePrice(money);
    }

    private static int validatePrice(final String inputPrice) {
        final int price = checkNonInteger(inputPrice);
        checkUnderMinimumPrice(price);

        return price;
    }

    private static int checkNonInteger(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Money.ERROR_PRICE_NON_INTEGER);
        }
    }

    private static void checkUnderMinimumPrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_MINIMUM_PRICE);
        }
    }

    public int numOfAvailablePurchase() {
        return money / LOTTO_PRICE;
    }

    public void purchaseLotto(int numOfLotto) {
        money -= (LOTTO_PRICE * numOfLotto);
    }

}
