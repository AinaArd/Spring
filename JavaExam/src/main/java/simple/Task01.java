package simple;

import java.util.ArrayList;
import java.util.Collections;

public class Task01 {

    public ArrayList<Integer> makeSorting() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(121212);
        numbers.add(123);
        DigitComparator comparator = new DigitComparator();
        Collections.sort(numbers, comparator);
        return numbers;
    }


}
