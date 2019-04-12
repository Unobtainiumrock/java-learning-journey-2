import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class AddSubtract extends Application {

	private Button addButton, subtractButton;
	private int operand1, operand2, result;
	private TextField operand1Field, operand2Field;
	private Text resultText;

	public void start(Stage primaryStage) {
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: yellow");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(10);

		operand1Field = new TextField();
		operand1Field.setOnAction(this::handleButtons);

		operand2Field = new TextField();
		operand2Field.setOnAction(this::handleButtons);

		HBox intervalBox = new HBox(operand1Field, operand2Field);
		intervalBox.setAlignment(Pos.CENTER);
		intervalBox.setSpacing(10);
		mainVBox.getChildren().add(intervalBox);

		addButton = new Button(" + ");
		addButton.setOnAction(this::handleButtons);
		subtractButton = new Button(" - ");
		subtractButton.setOnAction(this::handleButtons);

		HBox buttonBox = new HBox(addButton, subtractButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		mainVBox.getChildren().add(buttonBox);

		resultText = new Text(); // MODIFY THIS LINE IF NEEDED
		// YOUR CODE HERE

		HBox resultBox = new HBox(resultText);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		mainVBox.getChildren().add(resultBox);

		Scene scene = new Scene(mainVBox, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void handleButtons(ActionEvent event) {
		// YOUR CODE HERE
	}

	public static void main(String[] args) {
		launch(args);

	}

}
