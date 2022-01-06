package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.navigator.Navigator;

public class Launch extends Application {
    //public static void main(String[] args){}
    public static Navigator navigator;
    @Override
    public void start(Stage primaryStage) throws Exception {
        navigator=new Navigator(primaryStage);
        //todo tetris
    }
}
