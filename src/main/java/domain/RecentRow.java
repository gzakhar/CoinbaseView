package domain;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class RecentRow {

    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");

    private Date date;
    private Timestamp time;
    private String sym;
    private String exchange;
    private Double price;
    private Double size;
    private Double bid_price;
    private Double ask_price;
    private Integer service_id;

    public RecentRow() {
    }

    public RecentRow(Date date, String time, String sym, String exchange, Double price, Double size, Double bid_price, Double ask_price, Integer service_id) {
        this.date = date;
        this.time = Timestamp.valueOf(time.replace('T', ' '));
        this.sym = sym;
        this.exchange = exchange;
        this.price = price;
        this.size = size;
        this.bid_price = bid_price;
        this.ask_price = ask_price;
        this.service_id = service_id;
    }

//    public RecentRow(String date, String time, String sym, String exchange, Double price, Double size, Double bid_price, Double ask_price, Integer service_id) {
//        this.date = Date.valueOf(date);
//        this.time = Timestamp.valueOf(time.replace('T', ' '));
//        this.sym = sym;
//        this.exchange = exchange;
//        this.price = price;
//        this.size = size;
//        this.bid_price = bid_price;
//        this.ask_price = ask_price;
//        this.service_id = service_id;
//    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getSym() {
        return sym;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
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

    public Double getBid_price() {
        return bid_price;
    }

    public void setBid_price(Double bid_price) {
        this.bid_price = bid_price;
    }

    public Double getAsk_price() {
        return ask_price;
    }

    public void setAsk_price(Double ask_price) {
        this.ask_price = ask_price;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Long bin() {
        return Long.valueOf(this.formatedTime().replace(".", "").replace(":", ""));
    }

    public String formatedTime() {
        return timeFormat.format(this.getTime());
    }

    public int getMiliSeconds() {
        return Integer.valueOf(this.formatedTime().substring(9, 12));
    }

    public int getSeconds() {
        return Integer.valueOf(this.formatedTime().substring(6, 8));
    }

    public int getMints() {
        return Integer.valueOf(this.formatedTime().substring(3, 5));
    }

    public int getHour() {
        return Integer.valueOf(this.formatedTime().substring(0, 2));
    }

    public int getTotalSeconds() {
        return this.getSeconds() + (60 * getMints()) + (3600 * getHour());
    }


    @Override
    public String toString() {
        return "RecentRow{" +
                "date=" + date +
                ", time=" + time +
                ", sym='" + sym + '\'' +
                ", exchange='" + exchange + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", bid_price=" + bid_price +
                ", ask_price=" + ask_price +
                ", service_id=" + service_id +
                '}';
    }


}
