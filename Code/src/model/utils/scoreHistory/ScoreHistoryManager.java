package model.utils.scoreHistory;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.utils.Score;
import model.utils.comparator.AscDateComparator;
import model.utils.comparator.DescDateComparator;
import model.utils.comparator.ScoreComparator;
import model.utils.persistance.ScoreLoader;
import model.utils.persistance.ScoreSaver;

import java.net.URISyntaxException;
import java.util.ArrayList;


public class ScoreHistoryManager implements IScoreHistoryManager{

    private ObservableList<Score> scores;
    private ListProperty<Score> scoresProperty;
    @Override
    public ObservableList<Score> getScores() {return scoresProperty.get();}
    public void setScores(ObservableList<Score> value) {scoresProperty.set(value);}
    @Override
    public ListProperty<Score> getScoresProperty() {return scoresProperty;}

    private final String filePath;

    public ScoreHistoryManager() throws URISyntaxException {
        filePath="./save";
        var arr=new ScoreLoader().load(filePath);
        if (arr!=null)
            scores=FXCollections.observableArrayList(arr);
        else
            scores=FXCollections.observableArrayList();
        scoresProperty = new SimpleListProperty<>(scores);
    }

    @Override
    public void reload() {
        var tmp = FXCollections.observableArrayList(new ScoreLoader().load(filePath));
        scores.clear();
        //on fait comme ca pour que la propriete reste valide
        scores.addAll(tmp);
    }

    @Override
    public boolean save() {
        return (new ScoreSaver()).save(new ArrayList<>(scores),filePath);
    }

    @Override
    public ObservableList<Score> getByOrder(OrderBy order) {
        switch (order){
            case Best -> scores.sort(new ScoreComparator());
            case DateAsc -> scores.sort(new AscDateComparator());
            case DateDesc -> scores.sort(new DescDateComparator());
        }
        return scores;
    }

    @Override
    public void add(Score score) {
        if (!scores.contains(score))
            scores.add(score);
    }
}


