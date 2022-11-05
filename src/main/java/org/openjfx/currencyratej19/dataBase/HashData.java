package org.openjfx.currencyratej19.dataBase;

import org.openjfx.currencyratej19.privatBank.ParserPrivatBank;
import org.openjfx.currencyratej19.privatBank.PrivatPojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class HashData {
    public HashMap<String, BigDecimal> getHashData() {
        HashMap<String, BigDecimal> hashMap = new HashMap<>();
        String urlCashPrivat = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        String urlNonCashPrivat = "https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11";
        ParserPrivatBank pPrivat = new ParserPrivatBank();
        PrivatPojo[] privatPojos = pPrivat.coursePrivat(urlCashPrivat);
        PrivatPojo[] privatPojosNonCash = pPrivat.coursePrivat(urlNonCashPrivat);
        for (PrivatPojo unit :
                privatPojos) {
            if (unit.ccy.equals("USD") & unit.base_ccy.equals("UAH")) {
                hashMap.put("buyUSD_cash", ((unit.buy)));
                hashMap.put("saleUSD_cash", (unit.sale));
            }
            if (unit.ccy.equals("EUR") & unit.base_ccy.equals("UAH")) {
                hashMap.put("buyEUR_cash", (unit.buy));
                hashMap.put("saleEUR_cash", (unit.sale));
            }
            if (unit.ccy.equals("BTC") & unit.base_ccy.equals("USD")) {
                hashMap.put("buyBTC_cash", (unit.buy));
                hashMap.put("saleBTC_cash", (unit.sale));
            }
        }
        for (PrivatPojo unit1 :
                privatPojosNonCash) {
            if (unit1.ccy.equals("USD") & unit1.base_ccy.equals("UAH")) {
                hashMap.put("buyUSD_nCash", (unit1.buy));
                hashMap.put("saleUSD_nCash", (unit1.sale));
            }
            if (unit1.ccy.equals("EUR") & unit1.base_ccy.equals("UAH")) {
                hashMap.put("buyEUR_nCash", (unit1.buy));
                hashMap.put("saleEUR_nCash", (unit1.sale));
            }
            if (unit1.ccy.equals("BTC") & unit1.base_ccy.equals("USD")) {
                hashMap.put("buyBTC_nCash", (unit1.buy));
                hashMap.put("saleBTC_nCash", (unit1.sale));
            }
        }
        Date date = new Date();
        Double dateD = Double.valueOf(date.getTime());
        BigDecimal id = new BigDecimal(dateD);
        hashMap.put("id", id);
        return hashMap;
    }

}
