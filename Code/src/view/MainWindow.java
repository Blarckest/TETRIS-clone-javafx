package view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import launcher.Launch;

public class MainWindow {
    @FXML
    private Button playButton;

    @FXML
    private Button seeScoreButton;

    @FXML
    public void launchGame(){
        Launch.navigator.goToGame();
    }

    @FXML
    public void goToScore(){
        Launch.navigator.goToScore();
    }
}
