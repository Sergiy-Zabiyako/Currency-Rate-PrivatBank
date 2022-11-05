package org.openjfx.currencyratej19.privatBank;

import java.math.BigDecimal;
import java.util.HashMap;

public class ExchangeCource {
    public HashMap<String, BigDecimal> getExUAH(HashMap<String, BigDecimal> ex, String amountStr) {
        HashMap<String, BigDecimal> exUAH = new HashMap<>();
        Calculate cc = new Calculate();
        BigDecimal uahUSDbuy = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyUSD_cash")));
        exUAH.put("privatBuyCashUSD", uahUSDbuy);
        BigDecimal uahUSDsale = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleUSD_cash")));
        exUAH.put("privatSaleCashUSD", uahUSDsale);
        BigDecimal uahEURbuy = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyEUR_cash")));
        exUAH.put("privatBuyCashEUR", uahEURbuy);
        BigDecimal uahEURsale = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleEUR_cash")));
        exUAH.put("privatSaleCashEUR", uahEURsale);
        BigDecimal usdBTCbuy = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDbuy), ex.get("buyBTC_cash")));
        exUAH.put("privatBuyCashBTC", usdBTCbuy);
        BigDecimal usdBTCsale = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDsale), ex.get("saleBTC_cash")));
        exUAH.put("privatSaleCashBTC", usdBTCsale);

        BigDecimal uahUSDbuyN = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyUSD_nCash")));
        exUAH.put("privatBuyNonCashUSD", uahUSDbuyN);
        BigDecimal uahUSDsaleN = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleUSD_nCash")));
        exUAH.put("privatSaleNonCashUSD", uahUSDsaleN);
        BigDecimal uahEURbuyN = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyEUR_nCash")));
        exUAH.put("privatBuyNonCashEUR", uahEURbuyN);
        BigDecimal uahEURsaleN = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleEUR_nCash")));
        exUAH.put("privatSaleNonCashEUR", uahEURsaleN);
        BigDecimal usdBTCbuyN = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDbuyN), ex.get("buyBTC_nCash")));
        exUAH.put("privatBuyNonCashBTC", usdBTCbuyN);
        BigDecimal usdBTCsaleN = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDsaleN), ex.get("saleBTC_nCash")));
        exUAH.put("privatSaleNonCashBTC", usdBTCsaleN);
        exUAH.put("privatBuyCashUAH", new BigDecimal(amountStr));
        exUAH.put("privatSaleCashUAH", new BigDecimal(amountStr));
        exUAH.put("privatBuyNonCashUAH", new BigDecimal(amountStr));
        exUAH.put("privatSaleNonCashUAH", new BigDecimal(amountStr));

        return exUAH;
    }

    public HashMap<String, BigDecimal> getExUSD(HashMap<String, BigDecimal> ex, String amountStr) {
        HashMap<String, BigDecimal> exUSD = new HashMap<>();
        Calculate cc = new Calculate();
        BigDecimal usdUAHbuy = new BigDecimal(cc.getUSD(amountStr, ex.get("buyUSD_cash")));
        exUSD.put("privatBuyCashUAH", usdUAHbuy);
        BigDecimal usdUAHsale = new BigDecimal(cc.getUSD(amountStr, ex.get("saleUSD_cash")));
        exUSD.put("privatSaleCashUAH", usdUAHsale);
        BigDecimal uahEURbuy = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHbuy), ex.get("buyEUR_cash")));
        exUSD.put("privatBuyCashEUR", uahEURbuy);
        BigDecimal uahEURsale = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHsale), ex.get("saleEUR_cash")));
        exUSD.put("privatSaleCashEUR", uahEURsale);
        BigDecimal usdBTCbuy = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyBTC_cash")));
        exUSD.put("privatBuyCashBTC", usdBTCbuy);
        BigDecimal usdBTCsale = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleBTC_cash")));
        exUSD.put("privatSaleCashBTC", usdBTCsale);
        BigDecimal usdUAHbuyN = new BigDecimal(cc.getUSD(amountStr, ex.get("buyUSD_nCash")));
        exUSD.put("privatBuyNonCashUAH", usdUAHbuyN);
        BigDecimal usdUAHsaleN = new BigDecimal(cc.getUSD(amountStr, ex.get("saleUSD_nCash")));
        exUSD.put("privatSaleNonCashUAH", usdUAHsaleN);
        BigDecimal uahEURbuyN = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHbuyN), ex.get("buyEUR_nCash")));
        exUSD.put("privatBuyNonCashEUR", uahEURbuyN);
        BigDecimal uahEURsaleN = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHsaleN), ex.get("saleEUR_nCash")));
        exUSD.put("privatSaleNonCashEUR", uahEURsaleN);
        BigDecimal usdBTCbuyN = new BigDecimal(cc.getMultiply(amountStr, ex.get("buyBTC_nCash")));
        exUSD.put("privatBuyNonCashBTC", usdBTCbuyN);
        BigDecimal usdBTCsaleN = new BigDecimal(cc.getMultiply(amountStr, ex.get("saleBTC_nCash")));
        exUSD.put("privatSaleNonCashBTC", usdBTCsaleN);
        exUSD.put("privatBuyCashUSD", new BigDecimal(amountStr));
        exUSD.put("privatSaleCashUSD", new BigDecimal(amountStr));
        exUSD.put("privatBuyNonCashUSD", new BigDecimal(amountStr));
        exUSD.put("privatSaleNonCashUSD", new BigDecimal(amountStr));
        return exUSD;
    }

    public HashMap<String, BigDecimal> getExEUR(HashMap<String, BigDecimal> ex, String amountStr) {
        HashMap<String, BigDecimal> exEUR = new HashMap<>();
        Calculate cc = new Calculate();
        BigDecimal eurUAHbuy = new BigDecimal(cc.getUSD(amountStr, ex.get("buyEUR_cash")));
        exEUR.put("privatBuyCashUAH", eurUAHbuy);
        BigDecimal eurUAHsale = new BigDecimal(cc.getUSD(amountStr, ex.get("saleEUR_cash")));
        exEUR.put("privatSaleCashUAH", eurUAHsale);
        BigDecimal uahUSDbuy = new BigDecimal(cc.getMultiply(String.valueOf(eurUAHbuy), ex.get("buyUSD_cash")));
        exEUR.put("privatBuyCashUSD", uahUSDbuy);
        BigDecimal uahUSDsale = new BigDecimal(cc.getMultiply(String.valueOf(eurUAHsale), ex.get("saleUSD_cash")));
        exEUR.put("privatSaleCashUSD", uahUSDsale);
        BigDecimal usdBTCbuy = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDbuy), ex.get("buyBTC_cash")));
        exEUR.put("privatBuyCashBTC", usdBTCbuy);
        BigDecimal usdBTCsale = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDsale), ex.get("saleBTC_cash")));
        exEUR.put("privatSaleCashBTC", usdBTCsale);
        BigDecimal eurUAHbuyN = new BigDecimal(cc.getUSD(amountStr, ex.get("buyEUR_nCash")));
        exEUR.put("privatBuyNonCashUAH", eurUAHbuyN);
        BigDecimal eurUAHsaleN = new BigDecimal(cc.getUSD(amountStr, ex.get("saleEUR_nCash")));
        exEUR.put("privatSaleNonCashUAH", eurUAHsaleN);
        BigDecimal uahUSDbuyN = new BigDecimal(cc.getMultiply(String.valueOf(eurUAHbuyN), ex.get("buyUSD_nCash")));
        exEUR.put("privatBuyNonCashUSD", uahUSDbuyN);
        BigDecimal uahUSDsaleN = new BigDecimal(cc.getMultiply(String.valueOf(eurUAHsaleN), ex.get("saleUSD_nCash")));
        exEUR.put("privatSaleNonCashUSD", uahUSDsaleN);
        BigDecimal usdBTCbuyN = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDbuyN), ex.get("buyBTC_nCash")));
        exEUR.put("privatBuyNonCashBTC", usdBTCbuyN);
        BigDecimal usdBTCsaleN = new BigDecimal(cc.getMultiply(String.valueOf(uahUSDsaleN), ex.get("saleBTC_nCash")));
        exEUR.put("privatSaleNonCashBTC", usdBTCsaleN);
        exEUR.put("privatBuyCashEUR", new BigDecimal(amountStr));
        exEUR.put("privatSaleCashEUR", new BigDecimal(amountStr));
        exEUR.put("privatBuyNonCashEUR", new BigDecimal(amountStr));
        exEUR.put("privatSaleNonCashEUR", new BigDecimal(amountStr));
        System.out.println(exEUR);
        return exEUR;
    }

    public HashMap<String, BigDecimal> getExBTC(HashMap<String, BigDecimal> ex, String amountStr) {
        HashMap<String, BigDecimal> exBTC = new HashMap<>();
        Calculate cc = new Calculate();
        BigDecimal btcUSDbuy = new BigDecimal(cc.getUSD(amountStr, ex.get("buyBTC_cash")));
        exBTC.put("privatBuyCashUSD", btcUSDbuy);
        BigDecimal btcUSDsale = new BigDecimal(cc.getUSD(amountStr, ex.get("saleBTC_cash")));
        exBTC.put("privatSaleCashUSD", btcUSDsale);
        BigDecimal usdUAHbuy = new BigDecimal(cc.getUSD(String.valueOf(btcUSDbuy), ex.get("buyUSD_cash")));
        exBTC.put("privatBuyCashUAH", usdUAHbuy);
        BigDecimal usdUAHsale = new BigDecimal(cc.getUSD(String.valueOf(btcUSDsale), ex.get("saleUSD_cash")));
        exBTC.put("privatSaleCashUAH", usdUAHsale);
        BigDecimal uahEURbuy = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHbuy), ex.get("buyEUR_cash")));
        exBTC.put("privatBuyCashEUR", uahEURbuy);
        BigDecimal uahEURsale = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHsale), ex.get("saleEUR_cash")));
        exBTC.put("privatSaleCashEUR", uahEURsale);
        BigDecimal btcUSDbuyN = new BigDecimal(cc.getUSD(amountStr, ex.get("buyBTC_nCash")));
        exBTC.put("privatBuyNonCashUSD", btcUSDbuyN);
        BigDecimal btcUSDsaleN = new BigDecimal(cc.getUSD(amountStr, ex.get("saleBTC_nCash")));
        exBTC.put("privatSaleNonCashUSD", btcUSDsaleN);
        BigDecimal usdUAHbuyN = new BigDecimal(cc.getUSD(String.valueOf(btcUSDbuyN), ex.get("buyUSD_nCash")));
        exBTC.put("privatBuyNonCashUAH", usdUAHbuyN);
        BigDecimal usdUAHsaleN = new BigDecimal(cc.getUSD(String.valueOf(btcUSDsaleN), ex.get("saleUSD_nCash")));
        exBTC.put("privatSaleNonCashUAH", usdUAHsaleN);
        BigDecimal uahEURbuyN = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHbuyN), ex.get("buyEUR_nCash")));
        exBTC.put("privatBuyNonCashEUR", uahEURbuyN);
        BigDecimal uahEURsaleN = new BigDecimal(cc.getMultiply(String.valueOf(usdUAHsaleN), ex.get("saleEUR_nCash")));
        exBTC.put("privatSaleNonCashEUR", uahEURsaleN);
        exBTC.put("privatBuyCashBTC", new BigDecimal(amountStr));
        exBTC.put("privatSaleCashBTC", new BigDecimal(amountStr));
        exBTC.put("privatBuyNonCashBTC", new BigDecimal(amountStr));
        exBTC.put("privatSaleNonCashBTC", new BigDecimal(amountStr));
        System.out.println(exBTC);
        return exBTC;
    }
}
