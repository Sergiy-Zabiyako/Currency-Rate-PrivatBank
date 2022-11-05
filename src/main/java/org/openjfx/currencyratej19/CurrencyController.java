package org.openjfx.currencyratej19;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import org.openjfx.currencyratej19.dataBase.ConnDBprivatBank;
import org.openjfx.currencyratej19.dataBase.HashData;
import org.openjfx.currencyratej19.privatBank.ExchangeCource;

public class CurrencyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butConvert;
    @FXML
    private Text data;

    @FXML
    private Text answer;
    @FXML
    private TextField enterAmount;

    @FXML
    private ToggleGroup groupRadio;

    @FXML
    private Text privatBuyCashBTC;

    @FXML
    private Text privatBuyCashBTC1;

    @FXML
    private Text privatBuyCashEUR;

    @FXML
    private Text privatBuyCashEUR1;

    @FXML
    private Text privatBuyCashUAH;

    @FXML
    private Text privatBuyCashUSD;

    @FXML
    private Text privatBuyCashUSD1;

    @FXML
    private Text privatBuyNonCashBTC;

    @FXML
    private Text privatBuyNonCashBTC1;

    @FXML
    private Text privatBuyNonCashEUR;

    @FXML
    private Text privatBuyNonCashEUR1;

    @FXML
    private Text privatBuyNonCashUAH;

    @FXML
    private Text privatBuyNonCashUSD;

    @FXML
    private Text privatBuyNonCashUSD1;

    @FXML
    private Text privatSaleCashBTC;

    @FXML
    private Text privatSaleCashBTC1;

    @FXML
    private Text privatSaleCashEUR;

    @FXML
    private Text privatSaleCashEUR1;

    @FXML
    private Text privatSaleCashUAH;

    @FXML
    private Text privatSaleCashUSD;

    @FXML
    private Text privatSaleCashUSD1;

    @FXML
    private Text privatSaleNonCashBTC;

    @FXML
    private Text privatSaleNonCashBTC1;

    @FXML
    private Text privatSaleNonCashEUR;

    @FXML
    private Text privatSaleNonCashEUR1;

    @FXML
    private Text privatSaleNonCashUAH;

    @FXML
    private Text privatSaleNonCashUSD;

    @FXML
    private Text privatSaleNonCashUSD1;

    @FXML
    private RadioButton radioBTC;

    @FXML
    private RadioButton radioEUR;

    @FXML
    private RadioButton radioUAH;

    @FXML
    private RadioButton radioUSD;
    private HashMap<String, BigDecimal> ex;
    private HashMap<String, BigDecimal> exUAHrate;
    private HashMap<String, BigDecimal> exUSDrate;
    private HashMap<String, BigDecimal> exEURrate;
    private HashMap<String, BigDecimal> exBTCrate;

    @FXML
    void initialize() {
        String amountStr = enterAmount.getText().trim();
        System.out.println(amountStr);
        HashData hash = new HashData();
        ex = hash.getHashData();
        System.out.println(ex);
        float dateUnix = Float.valueOf(String.valueOf(ex.get("id")));
        Date date1 = new Date((long) dateUnix);
        data.setText(String.valueOf(date1));

        privatBuyCashUSD1.setText(ex.get("buyUSD_cash").toString());
        privatSaleCashUSD1.setText(ex.get("saleUSD_cash").toString());
        privatBuyCashEUR1.setText(ex.get("buyEUR_cash").toString());
        privatSaleCashEUR1.setText(ex.get("saleEUR_cash").toString());
        privatBuyCashBTC1.setText(ex.get("buyBTC_cash").toString());
        privatSaleCashBTC1.setText(ex.get("saleBTC_cash").toString());
        privatBuyNonCashUSD1.setText(ex.get("buyUSD_nCash").toString());
        privatSaleNonCashUSD1.setText(ex.get("saleUSD_nCash").toString());
        privatBuyNonCashEUR1.setText(ex.get("buyEUR_nCash").toString());
        privatSaleNonCashEUR1.setText(ex.get("saleEUR_nCash").toString());
        privatBuyNonCashBTC1.setText(ex.get("buyBTC_nCash").toString());
        privatSaleNonCashBTC1.setText(ex.get("saleBTC_nCash").toString());
        radioUAH.setSelected(true);

        ExchangeCource exUAHinit = new ExchangeCource();
        exUAHrate = exUAHinit.getExUAH(ex, amountStr);
        privatBuyCashUSD.setText(exUAHrate.get("privatBuyCashUSD").toString());
        privatSaleCashUSD.setText(exUAHrate.get("privatSaleCashUSD").toString());
        privatBuyCashEUR.setText(exUAHrate.get("privatBuyCashEUR").toString());
        privatSaleCashEUR.setText(exUAHrate.get("privatSaleCashEUR").toString());
        privatBuyCashBTC.setText(exUAHrate.get("privatBuyCashBTC").toString());
        privatSaleCashBTC.setText(exUAHrate.get("privatSaleCashBTC").toString());
        privatBuyNonCashUSD.setText(exUAHrate.get("privatBuyNonCashUSD").toString());
        privatSaleNonCashUSD.setText(exUAHrate.get("privatSaleNonCashUSD").toString());
        privatBuyNonCashEUR.setText(exUAHrate.get("privatBuyNonCashEUR").toString());
        privatSaleNonCashEUR.setText(exUAHrate.get("privatSaleNonCashEUR").toString());
        privatBuyNonCashBTC.setText(exUAHrate.get("privatBuyNonCashBTC").toString());
        privatSaleNonCashBTC.setText(exUAHrate.get("privatSaleNonCashBTC").toString());
        privatBuyCashUAH.setText(exUAHrate.get("privatBuyCashUAH").toString());
        privatSaleCashUAH.setText(exUAHrate.get("privatSaleCashUAH").toString());
        privatBuyNonCashUAH.setText(exUAHrate.get("privatBuyNonCashUAH").toString());
        privatSaleNonCashUAH.setText(exUAHrate.get("privatSaleNonCashUAH").toString());

        butConvert.setOnAction(actionEvent -> {
            ConnDBprivatBank connDB = new ConnDBprivatBank();
            connDB.getConnect(ex);
            answer.setText("Data is written to the database");
        });

        radioUAH.setOnAction(actionEvent -> {
            String amountStrUAH = enterAmount.getText();
            ExchangeCource exUAH = new ExchangeCource();
            exUAHrate = exUAH.getExUAH(ex, amountStrUAH);
            privatBuyCashUSD.setText(exUAHrate.get("privatBuyCashUSD").toString());
            privatSaleCashUSD.setText(exUAHrate.get("privatSaleCashUSD").toString());
            privatBuyCashEUR.setText(exUAHrate.get("privatBuyCashEUR").toString());
            privatSaleCashEUR.setText(exUAHrate.get("privatSaleCashEUR").toString());
            privatBuyCashBTC.setText(exUAHrate.get("privatBuyCashBTC").toString());
            privatSaleCashBTC.setText(exUAHrate.get("privatSaleCashBTC").toString());
            privatBuyNonCashUSD.setText(exUAHrate.get("privatBuyNonCashUSD").toString());
            privatSaleNonCashUSD.setText(exUAHrate.get("privatSaleNonCashUSD").toString());
            privatBuyNonCashEUR.setText(exUAHrate.get("privatBuyNonCashEUR").toString());
            privatSaleNonCashEUR.setText(exUAHrate.get("privatSaleNonCashEUR").toString());
            privatBuyNonCashBTC.setText(exUAHrate.get("privatBuyNonCashBTC").toString());
            privatSaleNonCashBTC.setText(exUAHrate.get("privatSaleNonCashBTC").toString());
            privatBuyCashUAH.setText(exUAHrate.get("privatBuyCashUAH").toString());
            privatSaleCashUAH.setText(exUAHrate.get("privatSaleCashUAH").toString());
            privatBuyNonCashUAH.setText(exUAHrate.get("privatBuyNonCashUAH").toString());
            privatSaleNonCashUAH.setText(exUAHrate.get("privatSaleNonCashUAH").toString());
        });

        radioUSD.setOnAction(actionEvent -> {
            String amountStrUSD = enterAmount.getText();
            ExchangeCource exUSD = new ExchangeCource();
            exUSDrate = exUSD.getExUSD(ex, amountStrUSD);
            privatBuyCashUAH.setText(exUSDrate.get("privatBuyCashUAH").toString());
            privatSaleCashUAH.setText(exUSDrate.get("privatSaleCashUAH").toString());
            privatBuyCashUSD.setText(String.valueOf(exUSDrate.get("privatBuyCashUSD")));
            privatSaleCashUSD.setText(exUSDrate.get("privatSaleCashUSD").toString());
            privatBuyCashEUR.setText(exUSDrate.get("privatBuyCashEUR").toString());
            privatSaleCashEUR.setText(exUSDrate.get("privatSaleCashEUR").toString());
            privatBuyCashBTC.setText(exUSDrate.get("privatBuyCashBTC").toString());
            privatSaleCashBTC.setText(exUSDrate.get("privatSaleCashBTC").toString());
            privatBuyNonCashUAH.setText(exUSDrate.get("privatBuyNonCashUAH").toString());
            privatSaleNonCashUAH.setText(exUSDrate.get("privatSaleNonCashUAH").toString());
            privatBuyNonCashUSD.setText(exUSDrate.get("privatBuyNonCashUSD").toString());
            privatSaleNonCashUSD.setText(exUSDrate.get("privatSaleNonCashUSD").toString());
            privatBuyNonCashEUR.setText(exUSDrate.get("privatBuyNonCashEUR").toString());
            privatSaleNonCashEUR.setText(exUSDrate.get("privatSaleNonCashEUR").toString());
            privatBuyNonCashBTC.setText(exUSDrate.get("privatBuyNonCashBTC").toString());
            privatSaleNonCashBTC.setText(exUSDrate.get("privatSaleNonCashBTC").toString());
        });

        radioEUR.setOnAction(actionEvent -> {
            String amountStrEUR = enterAmount.getText();
            ExchangeCource exEUR = new ExchangeCource();
            exEURrate = exEUR.getExEUR(ex, amountStrEUR);
            System.out.println(exEURrate);
            privatBuyCashUAH.setText(String.valueOf(exEURrate.get("privatBuyCashUAH")));
            privatSaleCashUAH.setText(String.valueOf(exEURrate.get("privatSaleCashUAH")));
            privatBuyCashUSD.setText(String.valueOf(exEURrate.get("privatBuyCashUSD")));
            privatSaleCashUSD.setText(String.valueOf(exEURrate.get("privatSaleCashUSD")));
            privatBuyCashEUR.setText(String.valueOf(exEURrate.get("privatBuyCashEUR")));
            privatSaleCashEUR.setText(String.valueOf(exEURrate.get("privatSaleCashEUR")));
            privatBuyCashBTC.setText(String.valueOf(exEURrate.get("privatBuyCashBTC")));
            privatSaleCashBTC.setText(String.valueOf(exEURrate.get("privatSaleCashBTC")));
            privatBuyNonCashUAH.setText(String.valueOf(exEURrate.get("privatBuyNonCashUAH")));
            privatSaleNonCashUAH.setText(String.valueOf(exEURrate.get("privatSaleNonCashUAH")));
            privatBuyNonCashUSD.setText(String.valueOf(exEURrate.get("privatBuyNonCashUSD")));
            privatSaleNonCashUSD.setText(String.valueOf(exEURrate.get("privatSaleNonCashUSD")));
            privatBuyNonCashEUR.setText(String.valueOf(exEURrate.get("privatBuyNonCashEUR")));
            privatSaleNonCashEUR.setText(String.valueOf(exEURrate.get("privatSaleNonCashEUR")));
            privatBuyNonCashBTC.setText(String.valueOf(exEURrate.get("privatBuyNonCashBTC")));
            privatSaleNonCashBTC.setText(String.valueOf(exEURrate.get("privatSaleNonCashBTC")));
        });

        radioBTC.setOnAction(actionEvent -> {
            String amountStrBTC = enterAmount.getText();
            ExchangeCource exBTC = new ExchangeCource();
            exBTCrate = exBTC.getExBTC(ex, amountStrBTC);
            System.out.println(exBTCrate);
            privatBuyCashUAH.setText(String.valueOf(exBTCrate.get("privatBuyCashUAH")));
            privatSaleCashUAH.setText(String.valueOf(exBTCrate.get("privatSaleCashUAH")));
            privatBuyCashUSD.setText(String.valueOf(exBTCrate.get("privatBuyCashUSD")));
            privatSaleCashUSD.setText(String.valueOf(exBTCrate.get("privatSaleCashUSD")));
            privatBuyCashEUR.setText(String.valueOf(exBTCrate.get("privatBuyCashEUR")));
            privatSaleCashEUR.setText(String.valueOf(exBTCrate.get("privatSaleCashEUR")));
            privatBuyCashBTC.setText(String.valueOf(exBTCrate.get("privatBuyCashBTC")));
            privatSaleCashBTC.setText(String.valueOf(exBTCrate.get("privatSaleCashBTC")));
            privatBuyNonCashUAH.setText(String.valueOf(exBTCrate.get("privatBuyNonCashUAH")));
            privatSaleNonCashUAH.setText(String.valueOf(exBTCrate.get("privatSaleNonCashUAH")));
            privatBuyNonCashUSD.setText(String.valueOf(exBTCrate.get("privatBuyNonCashUSD")));
            privatSaleNonCashUSD.setText(String.valueOf(exBTCrate.get("privatSaleNonCashUSD")));
            privatBuyNonCashEUR.setText(String.valueOf(exBTCrate.get("privatBuyNonCashEUR")));
            privatSaleNonCashEUR.setText(String.valueOf(exBTCrate.get("privatSaleNonCashEUR")));
            privatBuyNonCashBTC.setText(String.valueOf(exBTCrate.get("privatBuyNonCashBTC")));
            privatSaleNonCashBTC.setText(String.valueOf(exBTCrate.get("privatSaleNonCashBTC")));
        });


    }


}