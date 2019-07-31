package services;

import domain.Trades;

import java.util.Arrays;

public class Unpaginate {

    public static Trades[] join(Trades[] newTrades, Trades point) {

        Trades[] res = newTrades;

        for (int i = 0; i < (res.length / 2); i++) {
            Trades temp = res[i];
            res[i] = res[res.length - i - 1];
            res[res.length - i - 1] = temp;
        }

        return Arrays.stream(res).filter(s -> s.getTrade_id() > point.getTrade_id()).toArray(Trades[]::new);
    }
}
