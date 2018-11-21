package main;

import java.util.*;
import java.util.stream.Collectors;

public class Calendar {
    private List<Tuple> hours = new ArrayList<>();

    public void joinHours() {
        for (int i = 0; i < hours.size() - 1; i++) {
            if (hours.get(i + 1).key <= hours.get(i).value) {
                if (hours.get(i + 1).value <= hours.get(i).value) {
                    hours.remove(i + 1);
                    i--;
                } else {
                    hours.get(i).value = hours.get(i + 1).value;
                    hours.remove(i + 1);
                    i--;
                }
            }
        }
    }

    public void printHours(List<Tuple> hoursToPrint) {
        for (Tuple tuple : hoursToPrint) {
            System.out.print(tuple.toString() + " ");
        }
    }

    public void addHours(Tuple tuple) {
        hours.add(tuple);
    }

    public List<Tuple> sortHours() {
        return hours.stream().sorted(Comparator.comparing(o -> o.key)).
                collect(Collectors.toList());
    }

    public List<Tuple> getHours() {
        return hours;
    }

    public void setHours(List<Tuple> hours) {
        this.hours = hours;
    }
}
