package kiki;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Serves as the JavaFX entry point for the Kiki chatbot application.
 * Loads the main window layout from FXML and sets up the primary stage.
 */
public class Main extends Application {

    /** The Kiki chatbot instance shared with the main window controller. */
    private final Kiki kiki = new Kiki();

    /**
     * Starts the JavaFX application by loading the main window layout and displaying the stage.
     *
     * @param stage The primary stage provided by the JavaFX runtime.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("kiki");
            fxmlLoader.<MainWindow>getController().setDuke(kiki);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

