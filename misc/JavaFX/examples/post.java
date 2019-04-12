//package io.careerdeer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class FavoriteQuote extends Application {
	private Button button;
	private Scene scene;
	private Text currentQuote;
	private Random randomNum = new Random();

	// Does importing java.util.Arrays take up more resources than
	// java.util.ArrayList?. It not, I'm thinking this is a nice concise way of
	// making a List of Strings.
	private List quotes = List.of("The only thing I'm consistent at is being inconsistent. -myself",
			"This is the best of all possible worlds -Gottfried Willhelm Leibniz (paraphrased?)",
			"The mediocre teacher tells. The good teacher explains. The superior teacher demonstrates. The great teacher inspires. -William Arthur Ward");

	// Getting the following warning: Warning "The type Stage from module
	// javafx.graphics may not be accessible to clients due to missing 'requires
	// transitive'"
	// This is what my current module-info.java looks like. I'm assuming I need to
	// add something else to here?
	/*
	 * module io.careerdeer { requires javafx.graphics; requires javafx.controls;
	 * exports io.careerdeer to javafx.graphics; }
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create Pane
		Pane pane = new FlowPane();
		pane.setStyle("-fx-background-color: null;");
		
		// Create button
		button = new Button("Generate Random Quote.");
		button.setOnAction(this::handleClick);
		pane.getChildren().add(button);
		
		// Create Quote Text.
		// Ugly, I know. I didn't take time to clean these up since it's a discussion post
		currentQuote = new Text((String) this.quotes.get(this.randomNum.nextInt(this.quotes.size())));
		currentQuote.setFont(Font.font(20));
		pane.getChildren().add(currentQuote);
		
		
		// bind event handler to button Scratched this idea, don't have time to figure out how to access the correct "this" binding..
//		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//			}
//			
//		});	
		
		scene = new Scene(pane, 300, 300);
		scene.setFill(Color.ORANGE);
		
		primaryStage.setTitle("Random Quote");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handleClick(ActionEvent event) {
		currentQuote.setText((String) this.quotes.get(this.randomNum.nextInt(this.quotes.size())));
	}

	public static void main(String... args) {
		launch(args);
	}
}




