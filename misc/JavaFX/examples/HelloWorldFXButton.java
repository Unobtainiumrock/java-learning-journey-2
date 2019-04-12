import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorldFXButton extends Application {

	private Button button;
	private Text helloText;
	
	public void start(Stage primaryStage) {
		
		Pane pane = new FlowPane();
			
		button = new Button("Click Here!");
		button.setOnAction(this::handleButton);
		pane.getChildren().add(button);
		
		helloText = new Text("Hello World!");
		helloText.setFont(Font.font("Helvetica", 36));
		//helloText.setFill(Color.SALMON);
		helloText.setFill(Color.color(.25, .4, .15));
		pane.getChildren().add(helloText);
				
		Scene scene = new Scene(pane, 200, 200);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello");
		primaryStage.show();
	}
	
	// code here that should be executed when the user clicks the button
	private void handleButton(ActionEvent event) {
		helloText.setText("You clicked!");
		helloText.setFont(Font.font("Helvetica", 48));
		button.setDisable(true);
	}
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
