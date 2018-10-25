package co.teruh.calc.graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Display extends Application {
	
	
	@Override
	public void start(Stage displayStage) throws Exception {
		Scene scene = new Scene(new StackPane());
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainView.fxml"));
		scene.setRoot(fxmlLoader.load());
		
		displayStage.setTitle("Urwork");
		displayStage.setScene(scene);
		displayStage.setResizable(false);
		displayStage.show();
	}
		
	
	public void launch() {
		super.launch();
	}

}
