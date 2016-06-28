package io.digitalmagic;

public class OrderProcessor {

    public static void process(Order order) {
        StringBuilder sb = new StringBuilder()
            .append(order.getAction().toString().toLowerCase())
            .append(" ")
            .append(order.getQuantity())
            .append(" ");
        if (order.getTradeable() instanceof Order.Share || order.getTradeable() instanceof Share) {
            sb.append("shares of ");
        }
        sb.append(order.getTradeable().toString())
            .append(" at limit price ")
            .append(order.getLimitPrice());
        if (order.isAllOrNone()) {
            sb.append(" all or none");
        }
        System.out.println(sb);
    }

}
