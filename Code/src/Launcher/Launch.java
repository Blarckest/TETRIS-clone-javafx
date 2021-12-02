package Launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent view = FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml"));
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
        //todo tetris
    }
}
