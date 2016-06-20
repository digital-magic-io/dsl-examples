package io.digitalmagic;

public interface Order {

    public enum Action {
        BUY,
        SELL
    }

    String getSecurity();
    int getQuantity();
    double getLimitPrice();
    boolean isAllOrNone();
    double getValue();
    Action getAction();
}
