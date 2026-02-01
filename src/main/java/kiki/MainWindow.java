package kiki;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Kiki kiki;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/dog.jpg"));
    private Image kikiImage = new Image(this.getClass().getResourceAsStream("/images/kiki.jpg"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the kiki instance */
    public void setDuke(Kiki kiki) {
        this.kiki = kiki;
        dialogContainer.getChildren().add(DialogBox.getKikiDialog(kiki.getWelcomeMessage(), kikiImage));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing kiki's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = kiki.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKikiDialog(response, kikiImage)
        );
        userInput.clear();
    }
}
