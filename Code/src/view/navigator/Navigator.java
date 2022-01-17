package view.navigator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.utils.gameController.GameController;
import model.utils.looper.Looper;
import model.utils.looper.LooperAbs;
import view.GameOver;
import view.GameView;

import java.util.Objects;

/**
 * Classe permettant d'intéragir entre les différentes vues (Accueil, Jeu, Score, GameOver)
 */
public class Navigator {
    private final Stage m_stage;

    public Navigator(Stage stage) {

        m_stage = stage;

    }

    public void goToGame() {
        try {
            var location = getClass().getResource("/FXML/GameView.fxml");
            var fxmlLoader = new FXMLLoader(location, null);
            Parent view = fxmlLoader.load();
            m_stage.setScene(new Scene(view));
            GameController gc=new GameController(fxmlLoader.getController());
            LooperAbs looper=new Looper(((GameView)fxmlLoader.getController()).getPausedProperty(),((GameView)fxmlLoader.getController()).getStopThreadProperty());
            Thread thread=new Thread(looper);
            thread.setDaemon(true); //permet de kill le thread dans le cas ou l'appli se ferme anormalement (croix de la fenetre par exemple)
            thread.start();
            looper.subscribe(gc);
            m_stage.setMinHeight(700);
            m_stage.setMinWidth(600);
            m_stage.setHeight(700);
            m_stage.setWidth(600);
            m_stage.setMaxHeight(700);
            m_stage.setMaxWidth(600);
            m_stage.show();

        }
        catch (Exception e){
            error(e);
        }
    }
    public void goToScore(){
        try {
            Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/ScoreView.fxml")));
            m_stage.setScene(new Scene(view));
            m_stage.setMinHeight(300);
            m_stage.setMinWidth(300);
            m_stage.setHeight(800);
            m_stage.setWidth(600);
            m_stage.setMaxHeight(1080);
            m_stage.setMaxWidth(1920);
            m_stage.show();

        }
        catch (Exception e){
            error(e);
        }

    }
    public void goToGameOver(Text scoreValue){
        try {
            var location = getClass().getResource("/FXML/GameOver.fxml");
            var fxmlLoader = new FXMLLoader(location, null);
            Parent view = fxmlLoader.load();
            m_stage.setScene(new Scene(view));
            ((GameOver)fxmlLoader.getController()).setScoreValue(scoreValue);
            m_stage.setMinHeight(500);
            m_stage.setMinWidth(500);
            m_stage.setHeight(800);
            m_stage.setWidth(600);
            m_stage.setMaxHeight(1080);
            m_stage.setMaxWidth(1920);
            m_stage.show();
        }
        catch (Exception e){
            error(e);
        }

    }
    public void goToMenu(){
        try {
            Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainWindow.fxml")));
            m_stage.setScene(new Scene(view));
            m_stage.show();
            m_stage.setMinHeight(800);
            m_stage.setMinWidth(400);
            m_stage.setHeight(800);
            m_stage.setWidth(600);
            m_stage.setMaxHeight(1080);
            m_stage.setMaxWidth(1920);
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
