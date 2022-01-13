package view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import launch.Launcher;

/**
 * Code de la vue de la fenêtre principale, lorsque le joueur lance le jeu
 */
public class MainWindow {
    @FXML
    private Button playButton;

    @FXML
    private Button seeScoreButton;

    @FXML
    public void launchGame(){
        Launcher.navigator.goToGame();
    }

    @FXML
    public void goToScore(){
        Launcher.navigator.goToScore();
    }
}
