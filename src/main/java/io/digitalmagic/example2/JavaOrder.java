package io.digitalmagic.example2;

import io.digitalmagic.Order;
import io.digitalmagic.OrderValuer;

public class JavaOrder implements Order {

    public static class Builder {
        private String security;
        private int quantity;
        private double limitPrice;
        private boolean allOrNone;
        private double value;
        private Action action;

        public Builder buy(int quantity, String security) {
            this.action = Action.BUY;
            this.quantity = quantity;
            this.security = security;
            return this;
        }

        public Builder sell(int quantity, String security) {
            this.action = Action.SELL;
            this.quantity = quantity;
            this.security = security;
            return this;
        }

        public Builder atLimitPrice(double p) {
            this.limitPrice = p;
            return this;
        }

        public Builder allOrNone() {
            this.allOrNone = true;
            return this;
        }

        public Builder valueAs(OrderValuer ov) {
            this.value = ov.valueAs(quantity, limitPrice);
            return this;
        }

        public JavaOrder build() {
            return new JavaOrder(this);
        }
    }

    private final String security;
    private final int quantity;
    private final double limitPrice;
    private final boolean allOrNone;
    private final double value;
    private final Action action;

    private JavaOrder(Builder b) {
        security = b.security;
        quantity = b.quantity;
        limitPrice = b.limitPrice;
        allOrNone = b.allOrNone;
        value = b.value;
        action = b.action;
    }

    public static Builder buy(int quantity, String security) {
        return new Builder().buy(quantity, security);
    }

    public static Builder sell(int quantity, String security) {
        return new Builder().sell(quantity, security);
    }

    public String getSecurity() {
        return security;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    public boolean isAllOrNone() {
        return allOrNone;
    }

    public double getValue() {
        return value;
    }

    public Action getAction() {
        return action;
    }
}
