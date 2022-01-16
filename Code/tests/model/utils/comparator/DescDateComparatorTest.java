package model.utils.comparator;

import model.utils.Score;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DescDateComparatorTest {
    private Comparator comparator = new DescDateComparator();

    @Test
    void compare() {
        assertTrue(comparator.compare(new Score(), new Score()) > 0); //le premier est creer avant le second
        var s = new Score();
        assertTrue(comparator.compare(s, s) == 0);
        assertTrue(comparator.compare(new Score(), s) < 0);

    }
}