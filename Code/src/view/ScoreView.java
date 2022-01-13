package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Launcher;
import model.utils.Score;
import model.utils.scoreHistory.OrderBy;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Code de la vue d'affichage des scores du joueur
 */
public class ScoreView implements Initializable {
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
        sortChoice.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, number2) -> {
            switch ((String) sortChoice.getItems().get((Integer) number2)) {
                case "Meilleur" -> Launcher.scoreHistoryManager.getByOrder(OrderBy.Best);
                case "Plus recent" -> Launcher.scoreHistoryManager.getByOrder(OrderBy.DateDesc);
                case "Plus ancien" -> Launcher.scoreHistoryManager.getByOrder(OrderBy.DateAsc);
            }
        });
        scoresView.itemsProperty().bind(Launcher.scoreHistoryManager.getScoresProperty());
        scoresView.setCellFactory(__ -> new ListCell<Score>() {
            @Override
            protected void updateItem(Score item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    var dateScore = item.getDate();
                    Text date = new Text();
                    date.setText(dateScore.getDayOfMonth() + "/" + String.format("%02d", dateScore.getMonthValue()) + "/" + String.valueOf(dateScore.getYear()).substring(2, 4) + "  " + dateScore.getHour() + ":" + dateScore.getMinute());
                    date.setFill(Color.WHITESMOKE);

                    Text score = new Text();
                    score.setText(String.valueOf(item.getScore()));
                    score.setFill(Color.WHITESMOKE);

                    BorderPane pane = new BorderPane();
                    pane.leftProperty().setValue(date);
                    pane.rightProperty().setValue(score);
                    setGraphic(pane);
                } else {
                    setText("");
                    setGraphic(null);
                }
            }
        });
        sortChoice.getSelectionModel().select(0);
    }
}
