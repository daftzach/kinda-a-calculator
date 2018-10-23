package co.teruh.calc.graphics;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Display extends Application {
	
	@Override
	public void start(Stage displayStage) throws Exception {
		Scene scene = new Scene(new StackPane());
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainView.fxml"));
		scene.setRoot(fxmlLoader.load());
		
		MainController controller = fxmlLoader.getController();
		//controller.init();
		
		displayStage.setScene(scene);
		displayStage.show();
	}
		
	
	public void launch() {
		super.launch();
	}

}
