import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/UI.fxml")));
            Scene scene = new Scene(root);
            String css = Objects.requireNonNull(this.getClass().getResource("style/style.css")).toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Message");
            scene.setFill(null);
            stage.setScene(scene);
            stage.setResizable(false);

            stage.initStyle(StageStyle.TRANSPARENT);
            root.setOnMousePressed(actionEvent -> {
                xOffset = actionEvent.getSceneX();
                yOffset = actionEvent.getSceneY();
            });

            root.setOnMouseDragged(actionEvent -> {
                stage.setX(actionEvent.getScreenX() - xOffset);
                stage.setY(actionEvent.getScreenY() - yOffset);
            });

            stage.show();

            stage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}