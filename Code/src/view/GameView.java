package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import launcher.Launch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameView {
    @FXML
    private Button backButton;
    @FXML
    public ImageView sprites;
    @FXML
    public void goToMenu(){
        Launch.navigator.goToMenu();
    }

    public void initialize(){


            Image img1=new Image("img/sprites.png");
            sprites.setImage(img1);


    }
}
