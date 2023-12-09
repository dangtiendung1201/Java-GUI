import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
    @FXML
    TextField inputBox;
    @FXML
    VBox messageBox = new VBox();
    @FXML
    ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane.vvalueProperty().bind(messageBox.heightProperty());
        messageBox.setSpacing(5);
    }

    @FXML
    public void sendMessage(MouseEvent event) {
        addFriendMessage();
    }

    @FXML
    public void checkEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addUserMessage();
        }
    }

    public void addUserMessage() {
        if (inputBox.getText().isEmpty()) {
            return;
        }
        Label sentMessage = new Label(inputBox.getText());
        sentMessage.setWrapText(true);
        sentMessage.getStyleClass().add("user-message");
        HBox hBox = new HBox();
        hBox.getChildren().add(sentMessage);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        inputBox.setText("");
        messageBox.getChildren().add(hBox);
        scrollPane.setContent(messageBox);
    }

    public void addFriendMessage() {
        if (inputBox.getText().isEmpty()) {
            return;
        }
        Label sentMessage = new Label(inputBox.getText());
        sentMessage.setWrapText(true);
        sentMessage.getStyleClass().add("friend-message");
        HBox hBox = new HBox();
        hBox.getChildren().add(sentMessage);
        inputBox.setText("");
        messageBox.getChildren().add(hBox);
        scrollPane.setContent(messageBox);
    }
}