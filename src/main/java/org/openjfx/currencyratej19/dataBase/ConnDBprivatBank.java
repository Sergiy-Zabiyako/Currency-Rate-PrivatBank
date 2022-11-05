package org.openjfx.currencyratej19.dataBase;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;


public class ConnDBprivatBank {
    private final String URL = "jdbc:mysql://localhost:3306/currencyrate";
    private final String login = "root";
    private final String password = "admin";

    public ConnDBprivatBank() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getConnect(HashMap<String, BigDecimal> hashMapPrivat) {
        Date date = new Date();

        Double dateD = Double.valueOf(date.getTime());
        try {
            Connection connection = DriverManager.getConnection(URL, login, password);
            PreparedStatement prStatement = connection.prepareStatement("INSERT INTO PRIVATBANK (" +
                    "id, buyUSD_cash,saleUSD_cash,buyEUR_cash,saleEUR_cash, buyBTC_cash, saleBTC_cash," +
                    "buyUSD_ncash,saleUSD_ncash,buyEUR_ncash,saleEUR_ncash, buyBTC_ncash, saleBTC_ncash)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ;");
            prStatement.setDouble(1, dateD);
            //        prStatement.setBigDecimal(2, hashMapPrivat.get("buyUSD_cash"));
            prStatement.setBigDecimal(2, hashMapPrivat.get("buyUSD_cash"));
            prStatement.setBigDecimal(3, hashMapPrivat.get("saleUSD_cash"));
            prStatement.setBigDecimal(4, hashMapPrivat.get("buyEUR_cash"));
            prStatement.setBigDecimal(5, hashMapPrivat.get("saleEUR_cash"));
            prStatement.setBigDecimal(6, hashMapPrivat.get("buyBTC_cash"));
            prStatement.setBigDecimal(7, hashMapPrivat.get("saleBTC_cash"));
            prStatement.setBigDecimal(8, hashMapPrivat.get("buyUSD_nCash"));
            prStatement.setBigDecimal(9, hashMapPrivat.get("saleUSD_nCash"));
            prStatement.setBigDecimal(10, hashMapPrivat.get("buyEUR_nCash"));
            prStatement.setBigDecimal(11, hashMapPrivat.get("saleEUR_nCash"));
            prStatement.setBigDecimal(12, hashMapPrivat.get("buyBTC_nCash"));
            prStatement.setBigDecimal(13, hashMapPrivat.get("saleBTC_nCash"));
            prStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
