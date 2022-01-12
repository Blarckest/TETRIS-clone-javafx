package view;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import launch.Launcher;
import model.utils.Score;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoreView implements Initializable {
    @FXML
    public ScrollPane scoreScroller;
    @FXML
    public ListView scoresView;
    @FXML
    public ChoiceBox sortChoice;

    @FXML
    public void goToMenu(){
        Launcher.navigator.goToMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //sortChoice.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, number2) ->{
            //switch (sortChoice.getItems().get((Integer) number2)){

            //}
        //});
        scoresView.itemsProperty().bind(Launcher.scoreHistoryManager.getScoresProperty());
        scoresView.setCellFactory(__->{
            return new ListCell<Score>(){
                private Text date = null;
                private Text score = null;
                private BorderPane pane =null;
                @Override
                protected void updateItem(Score item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        var dateScore=item.getDate();
                        date = new Text();
                        date.setText(dateScore.getDayOfMonth()+"/"+String.format("%02d",dateScore.getMonthValue())+"/"+String.valueOf(dateScore.getYear()).substring(2,4)+"  "+dateScore.getHour()+":"+dateScore.getMinute());
                        score=new Text();
                        score.setText(String.valueOf(item.getScore()));
                        pane =new BorderPane();
                        pane.leftProperty().setValue(date);
                        pane.rightProperty().setValue(score);
                        setGraphic(pane);
                    } else {
                        setText("");
                        setGraphic(null);
                    }
                }
            };
        });
    }
}
