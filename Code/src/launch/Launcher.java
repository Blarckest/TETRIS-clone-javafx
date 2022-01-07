package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import view.navigator.Navigator;

public class Launcher extends Application {
    //public static void main(String[] args){}
    public static Navigator navigator;
    @Override
    public void start(Stage primaryStage) throws Exception {
        navigator=new Navigator(primaryStage);
        //todo tetris
    }
}
