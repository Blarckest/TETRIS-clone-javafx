package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Launcher;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Code de la vue de fin de partie, game over
 */
public class GameOver implements Initializable {
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
        Platform.exit();
    }
    public void setScoreValue(Text scoreValue){
        this.scoreValue.textProperty().setValue(scoreValue.textProperty().getValue());
    }

    @FXML
    public void hoverColorRestart(MouseEvent mouseEvent) {
        restartButton.setTextFill(Color.BLUEVIOLET);
    }

    @FXML
    public void mouseLeaveColorRestart(MouseEvent mouseEvent) {
        restartButton.setTextFill(Color.WHITE);
    }

    @FXML
    public void hoverColorScores(MouseEvent mouseEvent) {
        scoreButton.setTextFill(Color.YELLOW);
    }

    @FXML
    public void mouseLeaveColorScores(MouseEvent mouseEvent) {
        scoreButton.setTextFill(Color.WHITE);
    }

    @FXML
    public void hoverColorQuit(MouseEvent mouseEvent) {
        quitButton.setTextFill(Color.RED);
    }

    @FXML
    public void mouseLeaveColorQuit(MouseEvent mouseEvent) {
        quitButton.setTextFill(Color.WHITE);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        restartButton.setFont(Launcher.bigFont);
        scoreButton.setFont(Launcher.smallFont);
        quitButton.setFont(Launcher.smallFont);
    }
}
