package org.openjfx.currencyratej19.privatBank;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ParserPrivatBank {

    public ParserPrivatBank() {
    }

    public PrivatPojo[] coursePrivat(String urlCashPrivat) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        try {
            JsonReader jsonReadCashPrivat = new JsonReader(new InputStreamReader(new URL(urlCashPrivat).openStream()));
            PrivatPojo[] privatCash = gson.fromJson(jsonReadCashPrivat, PrivatPojo[].class);
            return privatCash;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
