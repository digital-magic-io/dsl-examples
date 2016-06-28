package io.digitalmagic;

public class OrderProcessor {

    public static void process(Order order) {
        StringBuilder sb = new StringBuilder()
            .append(order.getAction().toString().toLowerCase())
            .append(" ")
            .append(order.getQuantity())
            .append(" ");
        if (order.getTradeable() instanceof Order.Share || order.getTradeable() instanceof Api.Share) {
            sb.append("shares of ");
        }
        sb.append(order.getTradeable().toString())
            .append(" at limit price ")
            .append(order.getLimitPrice())
            .append(" ")
            .append(order.getPriceCurrency());

        System.out.println(sb);
    }

}
