package io.digitalmagic.example2;

public class Order implements io.digitalmagic.Order {

    public static class Builder {
        private Action action;
        private Tradeable tradeable;
        private Integer quantity;
        private Double limitPrice;
        private Boolean allOrNone = false;


        public Builder buy(int quantity) {
            this.action = Action.BUY;
            this.quantity = quantity;
            return this;
        }

        public Builder sell(int quantity) {
            this.action = Action.SELL;
            this.quantity = quantity;
            return this;
        }

        public Builder sharesOf(Share share) {
            this.tradeable = share;
            return this;
        }

        public Builder currency(Currency currency) {
            this.tradeable = currency;
            return this;
        }

        public Builder atPrice(Double limitPrice) {
            this.limitPrice = limitPrice;
            return this;
        }

        public Builder allOrNone() {
            this.allOrNone = true;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    private final Action action;
    private final Tradeable tradeable;
    private final Integer quantity;
    private final Double limitPrice;
    private final Boolean allOrNone;


    private Order(Builder b) {
        action = b.action;
        tradeable = b.tradeable;
        quantity = b.quantity;
        limitPrice = b.limitPrice;
        allOrNone = b.allOrNone;
    }

    public static Builder buy(int quantity) {
        return new Builder().buy(quantity);
    }

    public static Builder sell(int quantity) {
        return new Builder().sell(quantity);
    }

    public Action getAction() {
        return action;
    }

    public Tradeable getTradeable() {
        return tradeable;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getLimitPrice() {
        return limitPrice;
    }

    public Boolean isAllOrNone() {
        return allOrNone;
    }


}
