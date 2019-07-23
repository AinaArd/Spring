package simple;

import java.util.Comparator;

public class DigitComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        if (countDifferentDigits(o1) > countDifferentDigits(o2)) {
            return 1;
        } else if (countDifferentDigits(o1) == countDifferentDigits(o2)) {
            return 0;
        }
        return -1;
    }

    private int countDifferentDigits(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 10 > number / 10) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
