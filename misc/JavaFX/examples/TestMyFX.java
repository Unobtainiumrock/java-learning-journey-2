import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
 
public class TestMyFX extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        
        Text text = new Text("JavaFX!");
        text.setFont(Font.font("Helvetica", 20));
        text.setFill(Color.PURPLE);
        
        Pane pane = new StackPane(text);
        primaryStage.setScene(new Scene(pane, 100, 100));
        primaryStage.show();
    }  
    
	

    public static void main(String[] args) {
        launch(args);
    }
}