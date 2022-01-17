package launch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.utils.scoreHistory.IScoreHistoryManager;
import model.utils.scoreHistory.ScoreHistoryManager;
import view.navigator.Navigator;

public class Launcher extends Application {
    public static IScoreHistoryManager scoreHistoryManager;
    public static Navigator navigator;
    public static Font smallFont=Font.loadFont(Launcher.class.getResourceAsStream("/font/digital.ttf"),20);
    public static Font bigFont=Font.loadFont(Launcher.class.getResourceAsStream("/font/digital.ttf"),40);
    @Override
    public void start(Stage primaryStage) {
        navigator = new Navigator(primaryStage);
        scoreHistoryManager = new ScoreHistoryManager();
        try {
            navigator.goToMenu();
        } catch (Exception e) {
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        scoreHistoryManager.save();
        super.stop();
    }
}
