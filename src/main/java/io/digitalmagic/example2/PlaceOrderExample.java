package io.digitalmagic.example2;

import io.digitalmagic.Order;
import io.digitalmagic.OrderProcessor;
import io.digitalmagic.PremiumOrderValuer;
import io.digitalmagic.StandardOrderValuer;

public class PlaceOrderExample {

    private static Order buyApple() {
        return JavaOrder.buy(100, "Apple")
            .atLimitPrice(12.54)
            .allOrNone()
            .valueAs(new StandardOrderValuer())
            .build();
    }

    private static Order sellIBM() {
        return JavaOrder.sell(50, "IBM")
            .atLimitPrice(11.45)
            // We don't specify allOrNone - because wan't allow partial order
            .valueAs(new PremiumOrderValuer())
            .build();
    }

    public static void main(String[] args) {
        OrderProcessor.process(buyApple());
        OrderProcessor.process(sellIBM());
    }

}
