package view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import launch.Launcher;
import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import static javafx.scene.layout.GridPane.getColumnIndex;
import static javafx.scene.layout.GridPane.getRowIndex;

public class GameView implements Initializable {

    private static final double blockSize = 20;
    @FXML
    private BorderPane gameBoard;
    @FXML
    private GridPane gamePanel;
    @FXML
    private Text scoreValue;
    @FXML
    private GridPane nextBrick;
    @FXML
    private ToggleButton pauseButton;
    @FXML
    private VBox helpBox;
    @FXML
    private GridPane brickPanel;
    @FXML
    private Button backButton;
    @FXML
    public void goToMenu(){
        Launcher.navigator.goToMenu();
    }

    private final BooleanProperty isPauseProperty = new SimpleBooleanProperty();

    private final BooleanProperty isGameOverProperty = new SimpleBooleanProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gamePanel.setOnKeyPressed(keyEvent -> {
            if (isPauseProperty.getValue() == Boolean.FALSE && isGameOverProperty.getValue() == Boolean.FALSE) {
                if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.Q) {
                    //notifie gauche
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
                    //notifie droite
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.Z) {
                    //notifie rotation
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.S) {
                    //notifie descente
                    keyEvent.consume();
                }
            }
            if (keyEvent.getCode() == KeyCode.P) {
                pauseButton.selectedProperty().setValue(!pauseButton.selectedProperty().getValue());
            }

        });
        pauseButton.selectedProperty().bindBidirectional(isPauseProperty);
        pauseButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                pauseButton.setText("Resume");
            } else {
                pauseButton.setText("Pause");
            }
        });
    }

    public void initGameView(GridAbs grid) {
        for (int i = 0; i < grid.lignes; i++) {
            for (int j = 0; j < grid.colonnes; j++) {
                Rectangle rectangle = new Rectangle(blockSize, blockSize);
                rectangle.setFill(Color.TRANSPARENT);
                gamePanel.add(rectangle, j, i);
            }
        }
    }

    public void gameOver() {
        //gameOver
    }
    public void newGame(ActionEvent actionEvent) {
        //restart
    }


    public void bindScore(IntegerProperty integerProperty) {
        scoreValue.textProperty().bind(integerProperty.asString());
    }

    public void pauseGame(ActionEvent actionEvent) {
        gamePanel.requestFocus();
    }

    public void refreshGameBackground(GridAbs grid) {
        var children=gamePanel.getChildren();
        for(int i=0; i<children.size();i++)
        {
            var currentChild=(Rectangle)children.get(i);
            var currentBlock=(BlockAbs)grid.at(getRowIndex(currentChild),getColumnIndex(currentChild));
            if (currentBlock!=null)
                currentChild.setFill(currentBlock.getColor());
            else
                currentChild.setFill(Color.TRANSPARENT);
        }
    }
}
