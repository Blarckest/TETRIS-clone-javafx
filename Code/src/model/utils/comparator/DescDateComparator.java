package model.utils.comparator;

import model.utils.Score;

import java.util.Comparator;

/**
 * Permet de comparer des dates dans l'ordre descendant
 */
public class DescDateComparator implements Comparator<Score> {
    @Override
    public int compare(Score score1, Score score2) {
        return score2.getDate().compareTo(score1.getDate());
    }
}