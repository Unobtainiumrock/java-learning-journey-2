import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class IncDecButtons extends Application {

	private Text counterText;
	private Button incButton, decButton;
	private int counter, interval;
	private TextField intervalField;
	private Text intervalFieldLabel;
	
	public void start(Stage primaryStage) {
		counter = 0;
		interval = 1;
		
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: cyan");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(10);
		
		counterText = new Text("0");
		counterText.setFont(Font.font("Helvetica",28));
		counterText.setFill(Color.PURPLE);
		mainVBox.getChildren().add(counterText);
		

		incButton = new Button(" + ");
		incButton.setOnAction(this::handleButtons);
		decButton = new Button(" - ");
		decButton.setOnAction(this::handleButtons);

		HBox buttonBox = new HBox(incButton, decButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		mainVBox.getChildren().add(buttonBox);
		
		intervalFieldLabel = new Text("Interval: ");
		intervalField = new TextField("1");
		intervalField.setOnAction(this::handleButtons);
		
		HBox intervalBox = new HBox(intervalFieldLabel, intervalField);
		intervalBox.setAlignment(Pos.CENTER);
		intervalBox.setSpacing(10);
		mainVBox.getChildren().add(intervalBox);
		
		Scene scene = new Scene(mainVBox, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	
	private void handleButtons(ActionEvent event) {
		interval = Integer.parseInt(intervalField.getText());
		
		if(event.getSource()==incButton) {
			counter += interval;
		} else if(event.getSource()==decButton) {
			counter -= interval;
		}
		counterText.setText(Integer.toString(counter)); // could also say counter + ""
	}
	public static void main(String[] args) {
		launch(args);

	}

}
