package model.utils.comparator;

import model.utils.Score;

import java.util.Comparator;

/**
 * Permet de comparer des dates dans l'ordre ascendant
 */
public class AscDateComparator implements Comparator<Score> {
    @Override
    public int compare(Score score, Score t1) {
        return score.getDate().compareTo(t1.getDate());
    }
}
