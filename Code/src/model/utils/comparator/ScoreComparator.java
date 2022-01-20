package model.utils.comparator;

import model.utils.Score;

import java.util.Comparator;

/**
 * Permet de comparer des nombres dans l'ordre descendant
 */
public class ScoreComparator implements Comparator<Score> {
    @Override
    public int compare(Score score1, Score score2) {
        return score2.getScoreProperty().getValue().compareTo(score1.getScoreProperty().getValue());
    }
}