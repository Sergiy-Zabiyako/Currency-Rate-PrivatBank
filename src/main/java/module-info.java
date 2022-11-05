module org.openjfx.currencyratej19 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;


    opens org.openjfx.currencyratej19 to javafx.fxml;
    exports org.openjfx.currencyratej19;
    opens org.openjfx.currencyratej19.privatBank to javafx.fxml;
    exports org.openjfx.currencyratej19.privatBank;
    opens org.openjfx.currencyratej19.dataBase to javafx.fxml;
    exports org.openjfx.currencyratej19.dataBase;
}