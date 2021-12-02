package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launcher.Launch;

public class GameView {
    @FXML
    private Button backButton;

    @FXML
    public void goToMenu(){
        Launch.navigator.goToMenu();
    }
}
