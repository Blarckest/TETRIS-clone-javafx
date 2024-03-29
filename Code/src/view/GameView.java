package view;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import launch.Launcher;
import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;
import model.utils.event.EventSrc;
import model.utils.event.IEventListener;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.GridPane.getColumnIndex;
import static javafx.scene.layout.GridPane.getRowIndex;

/**
 * Code de la vue lorsque le joueur est en train de jouer
 */
public class GameView implements Initializable {

    private static final double blockSize = 30;

    private final List<IEventListener> eventListeners = new LinkedList<>();

    private final BooleanProperty isPauseProperty = new SimpleBooleanProperty();

    private final BooleanProperty isGameOverProperty = new SimpleBooleanProperty(false);

    private final BooleanProperty stopThreadProperty = new SimpleBooleanProperty(false);

    @FXML
    private GridPane gamePanel;
    @FXML
    private Text scoreValue;
    @FXML
    private Text score;
    @FXML
    private Text next;
    @FXML
    private GridPane nextTetroPreview;
    @FXML
    private ToggleButton pauseButton;
    @FXML
    private Button menuButton;

    public void goToMenu() {
        stopThreadProperty.setValue(true);
        Launcher.navigator.goToMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gamePanel.setFocusTraversable(true);
        gamePanel.requestFocus();
        gamePanel.setOnKeyPressed(keyEvent -> {
            if (isPauseProperty.getValue() == Boolean.FALSE && isGameOverProperty.getValue() == Boolean.FALSE) {
                if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.Q) {
                    for (var listener : eventListeners) {
                        listener.onLeftEvent(EventSrc.USER);
                    }
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
                    for (var listener : eventListeners) {
                        listener.onRightEvent(EventSrc.USER);
                    }
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.Z) {
                    for (var listener : eventListeners) {
                        listener.onRotateLeftEvent(EventSrc.USER);
                    }
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.S) {
                    for (var listener : eventListeners) {
                        listener.onDownEvent(EventSrc.USER);
                    }
                    keyEvent.consume();
                }
            }
            if (keyEvent.getCode() == KeyCode.P) {
                pauseButton.selectedProperty().setValue(!pauseButton.selectedProperty().getValue());
            }
            if (keyEvent.getCode() == KeyCode.G) {
                newGame();
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
        isGameOverProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                gameOver();
            }
        });
        menuButton.setFont(Launcher.bigFont);
        next.setFont(Launcher.bigFont);
        pauseButton.setFont(Launcher.bigFont);
        score.setFont(Launcher.bigFont);
        scoreValue.setFont(Launcher.bigFont);
    }

    public void initGameView(GridAbs grid, Tetrominos nextTetro) {
        for (int i = 0; i < grid.lines; i++) {
            for (int j = 0; j < grid.columns; j++) {
                Rectangle rectangle = new Rectangle(blockSize, blockSize);
                rectangle.setFill(Color.TRANSPARENT);
                gamePanel.add(rectangle, j, i);
            }
        }
        setNextTetro(nextTetro);
    }

    public void setNextTetro(Tetrominos nextTetro) {
        nextTetroPreview.getChildren().clear();
        var matrix = nextTetro.getCurrentShape();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Rectangle rectangle = new Rectangle(blockSize, blockSize);
                if (matrix[i][j] == null) {
                    rectangle.setFill(Color.TRANSPARENT);
                    nextTetroPreview.add(rectangle, j, i);
                } else {
                    rectangle.setFill(matrix[i][j].getColor());
                    nextTetroPreview.add(rectangle, j, i);
                }
            }
        }
    }

    public void gameOver() {
        if (isGameOverProperty.getValue()) {
            stopThreadProperty.setValue(true);
            Platform.runLater(() -> Launcher.navigator.goToGameOver(scoreValue));
        }
    }

    public void newGame() {
        for (var listener : eventListeners) {
            listener.createNewGame();
        }
    }


    public void bindScore(IntegerProperty integerProperty) {
        scoreValue.textProperty().bind(integerProperty.asString());
    }

    public void pauseGame() {
        gamePanel.requestFocus();
    }

    public void refreshGameBackground(GridAbs grid) {
        var children = gamePanel.getChildren();
        for (var child : children) {
            var currentChild = (Rectangle) child;
            var currentBlock = (BlockAbs) grid.at(getRowIndex(currentChild), getColumnIndex(currentChild));
            if (currentBlock != null)
                currentChild.setFill(currentBlock.getColor());
            else
                currentChild.setFill(Color.TRANSPARENT);
        }
    }

    public void addListener(IEventListener listener) {
        eventListeners.add(listener);
    }

    public void bindGameOver(BooleanProperty isGameOver) {
        this.isGameOverProperty.bind(isGameOver);
    }

    public BooleanProperty getPausedProperty() {
        return isPauseProperty;
    }

    public BooleanProperty getStopThreadProperty() {
        return stopThreadProperty;
    }

    @FXML
    public void hoverColorMenu(MouseEvent mouseEvent) {
        menuButton.setTextFill(Color.RED);
    }

    @FXML
    public void mouseLeaveColorMenu(MouseEvent mouseEvent) {
        menuButton.setTextFill(Color.WHITE);
    }
}
