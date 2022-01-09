package view.navigator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utils.gameController.GameController;

import java.net.URL;
import java.util.ResourceBundle;

public class Navigator {
    private Stage m_stage;
    public Navigator(Stage stage){
        m_stage=stage;
        try {
            goToMenu();
        }
        catch (Exception e){
            error(e);
        }
    }
    public void goToGame(){
        try {
            var location = getClass().getResource("/FXML/GameView.fxml");
            var fxmlLoader = new FXMLLoader(location, null);
            Parent view = fxmlLoader.load();
            m_stage.setScene(new Scene(view));
            new GameController(fxmlLoader.getController());
            m_stage.show();
        }
        catch (Exception e){
            error(e);
        }
    }
    public void goToScore(){
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/FXML/ScoreView.fxml"));
            m_stage.setScene(new Scene(view));
            m_stage.show();
        }
        catch (Exception e){
            error(e);
        }

    }
    public void goToMenu(){
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml"));
            m_stage.setScene(new Scene(view));
            m_stage.show();
        }
        catch (Exception e){
            error(e);
        }
    }

    private void error(Exception e){
        e.printStackTrace();
        m_stage.close();
    }
}
