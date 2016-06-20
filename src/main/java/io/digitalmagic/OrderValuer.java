package io.digitalmagic;

public interface OrderValuer {
    double valueAs(int qty, double unitPrice);
}
