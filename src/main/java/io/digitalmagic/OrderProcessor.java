package io.digitalmagic;

public class OrderProcessor {

    public static void process(Order order) {
        StringBuilder sb = new StringBuilder()
            .append(order.getAction().toString().toLowerCase())
            .append(" ")
            .append(order.getQuantity())
            .append(" '")
            .append(order.getSecurity())
            .append("' at limit price ")
            .append(order.getLimitPrice());
        if (order.isAllOrNone()) {
            sb.append(" all or none");
        }
        sb.append(" value as ").append(order.getValue());
        System.out.println(sb);
    }

}
