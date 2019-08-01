package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Test {

    public static void main(String[] args) throws IOException {


        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Z"};
        final AtomicInteger countSeconds = new AtomicInteger();
        final AtomicInteger countMints = new AtomicInteger();
        Arrays.stream(names)
                .collect(Collectors.groupingBy(i -> countSeconds.getAndIncrement() / 3))
                .values()
                .stream()
                .map(v -> new Entry(v.get(0), v.get(2)))
                .collect(Collectors.groupingBy(i -> countMints.getAndIncrement() / 5));


    }

}

class Entry {
    private String start;
    private String end;

    public Entry(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getClose() {
        return end;
    }

    public void setClose(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Entry is{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}




