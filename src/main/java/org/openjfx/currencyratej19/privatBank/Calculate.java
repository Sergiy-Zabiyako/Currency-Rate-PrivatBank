package org.openjfx.currencyratej19.privatBank;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calculate {
    public String getMultiply(String amount, BigDecimal course) {
        BigDecimal amountBig = new BigDecimal(amount);
        MathContext mc = new MathContext(4);
        BigDecimal multiply = amountBig.divide(course, mc);
        String result = String.valueOf(multiply);
        return result;
    }

    public String getUSD(String amount, BigDecimal course) {
        BigDecimal amountBig = new BigDecimal(amount);
        MathContext mc = new MathContext(4);
        BigDecimal multiply = amountBig.multiply(course, mc);
        String result = String.valueOf(multiply);
        return result;
    }
}