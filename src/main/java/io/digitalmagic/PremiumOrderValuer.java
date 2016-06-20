package io.digitalmagic;

public class PremiumOrderValuer implements OrderValuer {

    public double valueAs(int qty, double unitPrice) {
        return unitPrice * qty + 10;
    }

}
