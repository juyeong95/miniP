package miniProject;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage arg0) throws Exception { //첫번째 로그인 화면
		FXMLLoader loader = new FXMLLoader(getClass().getResource("event.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toString());
		arg0.setTitle("도서관리 프로그램");
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		
		arg0.setScene(scene);
		arg0.show();
	}

		public static void main(String[] args) {
			launch(args);
		}
}
