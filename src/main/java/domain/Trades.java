package domain;

import java.sql.Timestamp;

public class Trades {

    private Timestamp time;
    private Long trade_id;
    private Double price;
    private Double size;
    private String sell;

    @Override
    public String toString() {
        return "Trades{" +
                "time=" + time +
                ", trade_id=" + trade_id +
                ", price=" + price +
                ", size=" + size +
                ", sell='" + sell + '\'' +
                '}';
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(Long trade_id) {
        this.trade_id = trade_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

}
