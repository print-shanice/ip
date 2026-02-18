package kiki;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * Represents a single dialog box in the Kiki chatbot GUI, consisting of a small
 * circular profile picture and a styled text bubble. User messages are right-aligned
 * with a dark bubble; Kiki's replies are left-aligned with a light bubble.
 * Error responses from Kiki are rendered in a distinct red-tinted style.
 */
public class DialogBox extends HBox {
    /** The label displaying the dialog text as a styled bubble. */
    @FXML
    private Label dialog;

    /** The circular profile picture of the speaker. */
    @FXML
    private ImageView displayPicture;

    /** Bubble style for user messages. */
    private static final String USER_BUBBLE_STYLE =
            "-fx-background-color: #5b5ea6;"
                    + "-fx-background-radius: 16 4 16 16;"
                    + "-fx-text-fill: white;"
                    + "-fx-padding: 8 12 8 12;"
                    + "-fx-font-size: 13px;";

    /** Bubble style for normal Kiki replies. */
    private static final String KIKI_BUBBLE_STYLE =
            "-fx-background-color: #ffffff;"
                    + "-fx-background-radius: 4 16 16 16;"
                    + "-fx-text-fill: #222222;"
                    + "-fx-padding: 8 12 8 12;"
                    + "-fx-font-size: 13px;"
                    + "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 4, 0, 0, 1);";

    /** Bubble style for Kiki error replies. */
    private static final String ERROR_BUBBLE_STYLE =
            "-fx-background-color: #fdecea;"
                    + "-fx-background-radius: 4 16 16 16;"
                    + "-fx-text-fill: #b71c1c;"
                    + "-fx-padding: 8 12 8 12;"
                    + "-fx-font-size: 13px;"
                    + "-fx-border-color: #f5c6cb;"
                    + "-fx-border-radius: 4 16 16 16;"
                    + "-fx-border-width: 1;";

    /**
     * Constructs a DialogBox with the given text, profile image, and bubble style.
     * The profile picture is clipped to a circle for a polished avatar appearance.
     *
     * @param text        The text content to display in the bubble.
     * @param img         The profile image to display as a circular avatar.
     * @param labelStyle  The CSS style string to apply to the text bubble.
     */
    private DialogBox(String text, Image img, String labelStyle) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        dialog.setStyle(labelStyle);
        HBox.setMargin(dialog, new Insets(2, 4, 2, 4));

        displayPicture.setImage(img);
        // Clip the avatar to a circle
        Circle clip = new Circle(18, 18, 18);
        displayPicture.setClip(clip);
    }

    /**
     * Flips the layout to left-aligned, placing the avatar on the left for Kiki's messages.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.CENTER_LEFT);
    }

    /**
     * Creates and returns a right-aligned DialogBox for a user message.
     *
     * @param text The text content of the user's message.
     * @param img  The user's profile image.
     * @return A DialogBox styled and aligned as a user message.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, USER_BUBBLE_STYLE);
    }

    /**
     * Creates and returns a left-aligned DialogBox for a normal Kiki reply.
     *
     * @param text The text content of Kiki's reply.
     * @param img  Kiki's profile image.
     * @return A DialogBox styled and aligned as a normal Kiki reply.
     */
    public static DialogBox getKikiDialog(String text, Image img) {
        var db = new DialogBox(text, img, KIKI_BUBBLE_STYLE);
        db.flip();
        return db;
    }

    /**
     * Creates and returns a left-aligned DialogBox styled as a Kiki error reply.
     *
     * @param text The error text content to display.
     * @param img  Kiki's profile image.
     * @return A DialogBox styled and aligned as a Kiki error reply.
     */
    public static DialogBox getKikiErrorDialog(String text, Image img) {
        var db = new DialogBox(text, img, ERROR_BUBBLE_STYLE);
        db.flip();
        return db;
    }
}