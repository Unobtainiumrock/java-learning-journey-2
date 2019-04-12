import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorldFX extends Application {

	public void start(Stage primaryStage) {
		
		Pane pane = new FlowPane();
		Text helloText = new Text("Hello World!");
		helloText.setFont(Font.font("Helvetica", 36));
		//helloText.setFill(Color.SALMON);
		helloText.setFill(Color.color(.25, .4, .15));
		pane.getChildren().add(helloText);
		
		Scene scene = new Scene(pane, 200, 200, Color.GOLD);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
