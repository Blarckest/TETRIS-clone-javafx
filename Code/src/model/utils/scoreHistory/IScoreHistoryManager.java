package model.utils.scoreHistory;

import javafx.beans.property.ListProperty;
import model.utils.Score;

import java.util.List;

public interface IScoreHistoryManager {
    Score[] reload();
    boolean save();
    List<Score> getScores();
    ListProperty<Score> getScoresProperty();

    Score[] getByOrder(OrderBy order);

    void add(Score score);
}
