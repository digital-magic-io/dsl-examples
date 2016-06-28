package io.digitalmagic;

public interface Order {

    interface Tradeable {}

    enum Share implements Tradeable {
        Apple, IBM
    }

    enum Currency implements Tradeable {
        USD, EUR
    }

    enum Action {
        BUY, SELL
    }

    Action getAction();
    Tradeable getTradeable();
    Integer getQuantity();
    Double getLimitPrice();
    Currency getPriceCurrency();
}
