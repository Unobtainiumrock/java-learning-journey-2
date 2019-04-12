import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloUser extends Application {

	private Text messageText;
	private TextField nameInputField;
	private Button submitButton;
	
	public void start(Stage primaryStage) {
		
		Pane pane = new FlowPane();
		pane.setStyle("-fx-background-color: null;");
		
		messageText = new Text("Hello World!");
		messageText.setFont(Font.font(18));
		messageText.setFill(Color.DARKRED);
		pane.getChildren().add(messageText);
		
		Text nameInputFieldLabel = new Text("Enter your name:");
		pane.getChildren().add(nameInputFieldLabel);
		
		nameInputField = new TextField();
		nameInputField.setOnAction(this::processTextField);
		pane.getChildren().add(nameInputField);
		
		submitButton = new Button("Submit Name");
		submitButton.setOnAction(this::processTextField);
		pane.getChildren().add(submitButton);
		
		Scene scene = new Scene(pane, 200, 300, Color.SKYBLUE);
		
		primaryStage.setTitle("Hello User!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void processTextField(ActionEvent event) {
		String userInputText = nameInputField.getText();
		if(!userInputText.equals("")) {
			messageText.setText("Hello " + userInputText);
			nameInputField.clear();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
