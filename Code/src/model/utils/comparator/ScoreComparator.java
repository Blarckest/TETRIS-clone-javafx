package model.utils.comparator;

import model.utils.Score;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {
    @Override
    public int compare(Score score1, Score score2) {
        return score2.scoreProperty().getValue().compareTo(score1.scoreProperty().getValue());
    }
}