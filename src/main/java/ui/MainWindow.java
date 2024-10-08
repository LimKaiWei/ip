package ui;

import command.CommandType;
import elliot.Elliot;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import utility.Ui;


/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Elliot elliot;

    private Image userImage = new Image(this.getClass()
            .getResourceAsStream("/images/user.png"));
    private Image elliotImage = new Image(this.getClass()
            .getResourceAsStream("/images/elliot.png"));

    /**
     * Initialized anchor pane.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        Ui.introSay();
        dialogContainer.getChildren().addAll(
                DialogBox.getElliotDialog(Ui.getOutputString(), elliotImage, CommandType.LIST));
        Ui.flushOutputString();
    }

    /** Injects the Elliot instance */
    public void setElliot(Elliot d) {
        elliot = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing
     * Elliot's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws InterruptedException {
        String input = userInput.getText();
        String response = elliot.getResponse(input);
        CommandType commandType = elliot.getCommandType();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getElliotDialog(response, elliotImage, commandType)
        );
        userInput.clear();
        if (commandType == CommandType.BYE) {
            Platform.exit();
        }
    }
}
