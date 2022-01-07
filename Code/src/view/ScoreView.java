package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class ScoreView {
    @FXML
    private Button playButton;

    @FXML
    private Button seeScoreButton;

    @FXML
    public void goToMenu(){
        Launcher.navigator.goToMenu();
    }
}
