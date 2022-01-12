package launch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.utils.scoreHistory.IScoreHistoryManager;
import model.utils.scoreHistory.ScoreHistoryManager;
import view.navigator.Navigator;

import java.net.URI;

public class Launcher extends Application {
    public static IScoreHistoryManager scoreHistoryManager;
    public static Navigator navigator;
    @Override
    public void start(Stage primaryStage) throws Exception {
        navigator=new Navigator(primaryStage);
        scoreHistoryManager=new ScoreHistoryManager();
        try {
            navigator.goToMenu();
        }
        catch (Exception e){
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        scoreHistoryManager.save();
        super.stop();
    }
}
