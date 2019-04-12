import java.util.Random;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class LayoutPaneDemo extends Application {
	
	public void start(Stage primaryStage) {	
		
		/* FlowPane layout */
		
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3- A Longer Button");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5- The Longest Button in the Bunch");
		FlowPane flowPane = new FlowPane(button1, button2, button3, button4, button5); // can also use .getChildren().add(...) with any layout panes
		flowPane.setStyle("-fx-background-color: beige"); // css styling
		flowPane.setAlignment(Pos.CENTER); // more choices
		flowPane.setHgap(20); // set any gap size
		flowPane.setVgap(20); // set any gap size
		
		
		/* TilePane layout */	
		/*
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3- A Longer Button");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5- The Longest Button in the Bunch");
		TilePane pane = new TilePane(button1, button2, button3, button4, button5); 
		tilePane.setStyle("-fx-background-color: pink"); // css styling
		tilePane.setAlignment(Pos.CENTER); // more choices
		tilePane.setHgap(20); // set any gap size
		tilePane.setVgap(20); // set any gap size
		*/
		
		/*StackPane layout */
		/*
		ImageView imageView = new ImageView(new Image("dog.jpg"));
		Text text = new Text("Tessie!");
		Rectangle border = new Rectangle(120,150,Color.TRANSPARENT);
		border.setStroke(Color.CYAN);
		border.setStrokeWidth(10);
		//StackPane pane = new StackPane(imageView, text, border);
		StackPane stackPane = new StackPane();
		stackPane.setStyle("-fx-background-color: beige");
		stackPane.getChildren().add(imageView);
		stackPane.getChildren().add(text);
		stackPane.getChildren().add(border);
		*/
		
		/*HBox and VBox layouts */
		/*
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3- A Longer Button");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5- The Longest Button in the Bunch");
		HBox boxPane = new HBox(button1, button2, button3, button4, button5); 
		//VBox pane = new VBox(button1, button2, button3, button4, button5); 
		boxPane.setPadding(new Insets(50,10,50,10));
		boxPane.setSpacing(10);
		boxPane.setStyle("-fx-background-color: beige");
		*/
		
		/* Nesting panes with a VBox */
		//VBox nestedPanes = new VBox(stackPane, boxPane);

		/*Nesting panes with a BorderPane */
		/*
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(boxPane);
		borderPane.setCenter(stackPane);
			
		
		HBox dummyPaneLeft = new HBox(new Button("Button"));
		dummyPaneLeft.setStyle("-fx-background-color: red");
		borderPane.setLeft(dummyPaneLeft);
		
		HBox dummyPaneTop = new HBox(new Button("Button"));
		dummyPaneTop.setStyle("-fx-background-color: blue");
		borderPane.setTop(dummyPaneTop);
		
		HBox dummyPaneRight = new HBox(new Button("Button"));
		dummyPaneRight.setStyle("-fx-background-color: gray");
		borderPane.setRight(dummyPaneRight);
		*/
		
		/*
		
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: beige"); // css styling
		//gridPane.setHgap(10); // set any gap size
		//gridPane.setVgap(10); // set any gap size
		gridPane.setGridLinesVisible(true);
		
		ImageView imageView = new ImageView(new Image("dog.jpg"));
		gridPane.add(imageView, 0, 0, 1, 3);
		
		Text text = new Text("Hello!");
		gridPane.add(text, 1, 0);
		
		Button button = new Button("Button");
		gridPane.add(button,  1,  1);
		*/
		
		/* view the different layout panes */
		Scene scene = new Scene(flowPane, 300, 300, Color.TRANSPARENT); // change the layout pane to see different options- comment out all but one at a time!
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
