import domain.Trades;
import services.ConnectorImpl;
import services.Unpaginate;
import util.Operations;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {

        String url = "https://api.pro.coinbase.com/products/BTC-USD/trades";
        Operations<Trades> util = new Operations<>();
        Stack<Trades> history = new Stack<>();
        Trades[] arr = ConnectorImpl.pull(url);

        int seconds = 0;
        while (seconds < 100) {

            if (history.empty()) {
                Arrays.stream(util.reverse(ConnectorImpl.pull(url))).forEach(history::push);
                continue;
            }

            Arrays.stream(Unpaginate.join(ConnectorImpl.pull(url), history.peek())).forEach(history::push);

            TimeUnit.SECONDS.sleep(1);
            System.out.println(seconds);
            seconds++;
        }

        history.forEach(System.out::println);
    }
}
