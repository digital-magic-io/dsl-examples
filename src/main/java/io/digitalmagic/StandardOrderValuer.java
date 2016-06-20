package io.digitalmagic;

public class StandardOrderValuer implements OrderValuer {

    public double valueAs(int qty, double unitPrice) {
        return unitPrice * qty;
    }

}
