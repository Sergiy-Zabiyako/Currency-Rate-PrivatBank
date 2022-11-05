package org.openjfx.currencyratej19.privatBank;

import java.math.BigDecimal;
public class PrivatPojo {

    public String ccy;
    public String base_ccy;
    public BigDecimal buy;
    public BigDecimal sale;

    public PrivatPojo(String ccy, String base_ccy, BigDecimal buy, BigDecimal sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }


    @Override
    public String toString() {
        return "PrivatPojo{" +
                "ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}

