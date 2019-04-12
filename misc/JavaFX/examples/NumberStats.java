import java.util.ArrayList;
import java.util.Collections;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class NumberStats extends Application {

	private Text numberFieldLabel;
	private TextField numberField;
	private Button calculateButton, clearButton;
	private Text resultText;

	private ArrayList<Integer> numberList;

	public void start(Stage primaryStage) {
		numberList = new ArrayList<Integer>();

		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: beige");
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);

		numberFieldLabel = new Text("Enter a number:");
		numberField = new TextField();
		numberField.setOnAction(this::processNumberTextField);
		TilePane numberPane = new TilePane(numberFieldLabel, numberField);
		gridPane.add(numberPane, 0, 0);

		calculateButton = new Button("Calculate");
		calculateButton.setOnAction(this::handleCalculateButton);
		clearButton = new Button("Clear");
		clearButton.setOnAction(this::handleClearButton);
		TilePane buttonPane = new TilePane(calculateButton, clearButton);
		gridPane.add(buttonPane, 0, 1);

		resultText = new Text("");
		gridPane.add(resultText, 0, 2);

		Scene scene = new Scene(gridPane, 200, 300);
		primaryStage.setTitle("Number Stats");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void handleClearButton(ActionEvent event) {
		numberList.clear();
		resultText.setText("");
	}

	private void handleCalculateButton(ActionEvent event) {
		if (!numberList.isEmpty()) {
			int total = 0, min, max;
			double average;

			for (int n : numberList) {
				total += n;
			}

			min = Collections.min(numberList);
			max = Collections.max(numberList);

			average = ((double) total) / numberList.size();

			String resultString = "Min = " + min + "\n" + "Max = " + max + "\n" + "Total = " + total + "\n"
					+ "Average = " + average;

			resultText.setText(resultString);
			resultText.setFill(Color.BLACK);
		} else {
			resultText.setText("Error: empty list");
			resultText.setFill(Color.RED);
		}
	}

	private void processNumberTextField(ActionEvent event) {
		try {
			int userNumber = Integer.parseInt(numberField.getText());
			numberList.add(userNumber);
			resultText.setText("");
		} catch (NumberFormatException ex) {
			resultText.setText("Error: not a number!");
			resultText.setFill(Color.RED);
		} finally {
			numberField.clear();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
