package io.digitalmagic.example2;

import io.digitalmagic.OrderProcessor;
import io.digitalmagic.PremiumOrderValuer;
import io.digitalmagic.StandardOrderValuer;

public class PlaceOrderExample {

    private static void process(Order ... orders) {
        for (Order order: orders) {
            OrderProcessor.process(order);
        }
    }

    public static void main(String[] args) {
        process(
                Order.buy(100)
                        .sharesOf("Apple")
                        .atLimitPrice(12.54)
                        .allOrNone()
                        .valueAs(new StandardOrderValuer())
                        .build(),

            Order.sell(50)
                    .sharesOf("IBM")
                    .atLimitPrice(11.45)
                    // We don't specify allOrNone - because wan't allow partial order
                    .valueAs(new PremiumOrderValuer())
                    .build()
        );
    }
}
