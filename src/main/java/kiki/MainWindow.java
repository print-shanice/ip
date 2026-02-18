package kiki;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 * Acts as the JavaFX controller for the Kiki chatbot's main application window.
 * Manages the dialog container, user input field, and send button,
 * and connects the UI to the {@link Kiki} backend.
 */
public class MainWindow {
    /** The scroll pane that contains the dialog container. */
    @FXML
    private ScrollPane scrollPane;

    /** The vertical container holding all dialog box entries. */
    @FXML
    private VBox dialogContainer;

    /** The text field where the user types their input. */
    @FXML
    private TextField userInput;

    /** The button the user clicks to send their message. */
    @FXML
    private Button sendButton;

    /** The Kiki chatbot instance used to process user input and generate responses. */
    private Kiki kiki;

    /** The profile image representing the user in the dialog. */
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/dog.jpg"));

    /** The profile image representing Kiki in the dialog. */
    private Image kikiImage = new Image(this.getClass().getResourceAsStream("/images/kiki.jpg"));

    /**
     * Initialises the main window after all FXML elements have been loaded.
     * Binds the scroll pane's vertical scroll position to the dialog container's height
     * so the view automatically scrolls to the latest message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the Kiki chatbot instance into the controller and displays the welcome message.
     *
     * @param kiki The Kiki instance to use for processing user input.
     */
    public void setDuke(Kiki kiki) {
        this.kiki = kiki;
        dialogContainer.getChildren().add(DialogBox.getKikiDialog(kiki.getWelcomeMessage(), kikiImage));
    }

    /**
     * Handles the user's input when the send button is clicked or Enter is pressed.
     * Appends the user's message and Kiki's response as dialog boxes to the container,
     * then clears the input field.
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
        assert userInput.getText().isEmpty() : "User input should be cleared after handling";
    }
}
