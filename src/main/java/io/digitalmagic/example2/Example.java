package io.digitalmagic.example2;

import io.digitalmagic.OrderProcessor;
import io.digitalmagic.Order.*;

public class Example {

    private static void process(Order ... orders) {
        for (Order order: orders) {
            OrderProcessor.process(order);
        }
    }

    public static void main(String[] args) {
        process(
            Order.buy(300).currency(Currency.EUR).atPrice(250.00).allOrNone().build(),
            Order.sell(100).sharesOf(Share.Apple).atPrice(10.35).build()
        );
    }
}
