package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.RecentRow;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Test {

    public static void main(String[] args) throws IOException {


        FileReader fileReader = new FileReader("/Users/george/Downloads/test.json");

        ObjectMapper mapper = new ObjectMapper();

        RecentRow[] recent = mapper.readValue(fileReader, RecentRow[].class);


//        Map<String, Map<Integer, List<RecentRow>>> res =  Arrays.stream(recent)
//                .collect(Collectors.groupingBy(RecentRow::getExchange, Collectors.groupingBy(RecentRow::getTotalSeconds)));
//
//        System.out.println(res.get("Coinbase_pro").get(56321));


        Arrays.stream(recent)
                .collect(Collectors.groupingBy(RecentRow::getExchange, Collectors.groupingBy(RecentRow::getTotalSeconds)))
                .values()
                .forEach(exchage -> {
                    exchage.values()
                            .stream()
                            .map(second -> new SecondReturn(second.get(0).getExchange(), second.get(0).getPrice(), second.get(second.size() - 1).getPrice(), second.get(0).getTotalSeconds()));
                });


//        Arrays.stream(recent)
//                .collect(Collectors.groupingBy(RecentRow::getExchange, Collectors.groupingBy(RecentRow::getTotalSeconds)))
//                .values()
//                .forEach(exchage -> {
//                    exchage.values()
//                            .stream()
//                            .map(second -> new SecondReturn(second.get(0).getExchange(), second.get(0).getPrice(), second.get(second.size() - 1).getPrice(), second.get(0).getTotalSeconds()))
//                            .forEach();
//                });


//        Arrays.stream(recent)
//                .collect(Collectors.groupingBy(RecentRow::getExchange, Collectors.groupingBy(RecentRow::getTotalSeconds)))
//                .values()
//                .forEach(System.out::println);
//                .stream()
//                .map(v -> new SecondReturn(v.get(0).getPrice(), v.get(v.size() - 1).getPrice(), v.get(0).getTotalSeconds()))
//                .forEach(System.out::println);


//
//        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Z"};
//        final AtomicInteger countSeconds = new AtomicInteger();
//        final AtomicInteger countMints = new AtomicInteger();
//        Arrays.stream(names)
//                .collect(Collectors.groupingBy(i -> countSeconds.getAndIncrement() / 3))
//                .values()
//                .stream()
//                .map(v -> new Entry(v.get(0), v.get(2)))
//                .collect(Collectors.groupingBy(i -> countMints.getAndIncrement() / 5))
//                .values()
//                .stream()
//                .map();


    }

}

class Entry {
    private String open;
    private String close;

    public Entry(String open, String close) {
        this.open = open;
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "Entry is{" +
                "open='" + open + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}

class FinEntry {
    private String first;
    private String last;

    public FinEntry(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "FinEntry is{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}


class SecondReturn {
    private String exchange;
    private Double open;
    private Double close;
    private Integer time;

    public SecondReturn(String exchange, Double open, Double close, Integer time) {
        this.exchange = exchange;
        this.open = open;
        this.close = close;
        this.time = time;
    }


    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }


    @Override
    public String toString() {
        return "SecondReturn{" +
                "exchange='" + exchange + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", time=" + time +
                '}';
    }
}

class MinuteBin {
    private Double open;
    private Double close;

    public MinuteBin(Double open, Double close) {
        this.open = open;
        this.close = close;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "MinuteBin{" +
                "open=" + open +
                ", close=" + close +
                '}';
    }
}




