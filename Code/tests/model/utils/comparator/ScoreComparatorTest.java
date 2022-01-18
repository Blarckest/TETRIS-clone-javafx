package model.utils.comparator;

import model.utils.Score;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreComparatorTest {
    private final Comparator comparator = new ScoreComparator();

    @Test
    void compare() {
        assertTrue(comparator.compare(new Score(), new Score()) == 0);
        assertTrue(comparator.compare(new Score(3, LocalDateTime.now()), new Score(2, LocalDateTime.now())) < 0);
        assertTrue(comparator.compare(new Score(2, LocalDateTime.now()), new Score(3, LocalDateTime.now())) > 0);
    }
}