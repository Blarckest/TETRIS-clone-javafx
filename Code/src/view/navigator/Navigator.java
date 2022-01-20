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
 * Classe permettant d'interagir entre les differentes vues (Accueil, Jeu, Score, GameOver)
 */
public class Navigator {
    private final Stage m_stage;

    public Navigator(Stage stage) {

        m_stage = stage;

    }

    public void setUpWindow(int minHeight, int minWidth, int height, int width, int maxHeight, int maxWidth) {
        m_stage.setMinHeight(minHeight);
        m_stage.setMinWidth(minWidth);
        m_stage.setHeight(height);
        m_stage.setWidth(width);
        m_stage.setMaxHeight(maxHeight);
        m_stage.setMaxWidth(maxWidth);
    }

    public void goToGame() {
        try {
            var location = getClass().getResource("/FXML/GameView.fxml");
            var fxmlLoader = new FXMLLoader(location, null);
            Parent view = fxmlLoader.load();
            m_stage.setScene(new Scene(view));
            GameController gc = new GameController(fxmlLoader.getController());
            LooperAbs looper = new Looper(((GameView) fxmlLoader.getController()).getPausedProperty(), ((GameView) fxmlLoader.getController()).getStopThreadProperty());
            Thread thread = new Thread(looper);
            thread.setDaemon(true); //permet de kill le thread dans le cas ou l'appli se ferme anormalement (croix de la fenetre par exemple)
            thread.start();
            looper.subscribe(gc);
            setUpWindow(700, 600, 700, 600, 700, 600);
            m_stage.show();

        } catch (Exception e) {
            error(e);
        }
    }

    public void goToScore() {
        try {
            Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/ScoreView.fxml")));
            m_stage.setScene(new Scene(view));
            setUpWindow(300, 300, 800, 600, 1080, 1920);
            m_stage.show();

        } catch (Exception e) {
            error(e);
        }

    }

    public void goToGameOver(Text scoreValue) {
        try {
            var location = getClass().getResource("/FXML/GameOver.fxml");
            var fxmlLoader = new FXMLLoader(location, null);
            Parent view = fxmlLoader.load();
            m_stage.setScene(new Scene(view));
            ((GameOver) fxmlLoader.getController()).setScoreValue(scoreValue);
            setUpWindow(500, 500, 800, 600, 1080, 1920);
            m_stage.show();
        } catch (Exception e) {
            error(e);
        }

    }

    public void goToMenu() {
        try {
            Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/MainWindow.fxml")));
            m_stage.setScene(new Scene(view));
            setUpWindow(800, 400, 800, 600, 1080, 1920);
            m_stage.show();
        } catch (Exception e) {
            error(e);
        }
    }

    private void error(Exception e) {
        e.printStackTrace();
        m_stage.close();
    }
}
