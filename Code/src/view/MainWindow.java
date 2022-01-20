package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import launch.Launcher;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Code de la vue de la fenetre principale, lorsque le joueur lance le jeu
 */
public class MainWindow implements Initializable {
    @FXML
    private Button playButton;

    @FXML
    private Button seeScoreButton;

    public void launchGame(){
        Launcher.navigator.goToGame();
    }

    public void goToScore(){
        Launcher.navigator.goToScore();
    }


    @FXML
    public void hoverColorPlay(MouseEvent mouseEvent) {
        playButton.setTextFill(Color.WHITE);
    }

    @FXML
    public void mouseLeaveColorPlay(MouseEvent mouseEvent) {
        playButton.setTextFill(Color.YELLOW);
    }

    @FXML
    public void hoverColorScores(MouseEvent mouseEvent) {
        seeScoreButton.setTextFill(Color.WHITE);
    }

    @FXML
    public void mouseLeaveColorScores(MouseEvent mouseEvent) {
        seeScoreButton.setTextFill(Color.YELLOW);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playButton.setFont(Launcher.bigFont);
        seeScoreButton.setFont(Launcher.smallFont);
    }
}
