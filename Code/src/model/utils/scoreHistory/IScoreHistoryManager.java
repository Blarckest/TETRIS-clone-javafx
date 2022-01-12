package model.utils.scoreHistory;

import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import model.utils.Score;

import java.util.List;

public interface IScoreHistoryManager {
    Score[] reload();
    boolean save();
    List<Score> getScores();
    ListProperty<Score> getScoresProperty();

    ObservableList<Score> getByOrder(OrderBy order);

    void add(Score score);
}
