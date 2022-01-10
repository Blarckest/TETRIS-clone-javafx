package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import launch.Launcher;

public class GameOver {
    @FXML
    private Text scoreValue;
    @FXML
    private Button restartButton;
    @FXML
    private Button scoreButton;
    @FXML
    private Button quitButton;

    public void restartGame(ActionEvent actionEvent) {
        Launcher.navigator.goToGame();
    }

    public void goToScore(ActionEvent actionEvent) {
        Launcher.navigator.goToScore();
    }

    public void quitGame(ActionEvent actionEvent) {
        System.exit(0);
    }
    public void setScoreValue(Text scoreValue){
        this.scoreValue.textProperty().setValue(scoreValue.textProperty().getValue());
    }
}
