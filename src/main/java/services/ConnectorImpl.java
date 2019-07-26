package services;

import com.google.gson.Gson;
import domain.Trades;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectorImpl {

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    public static Trades[] pull(String url) throws Exception {

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder responce = new StringBuilder();

        while ((inputLine = in.readLine()) != null) responce.append(inputLine);

        in.close();

        return new Gson().fromJson(responce.toString(), Trades[].class);
    }
}
