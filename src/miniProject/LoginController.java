package miniProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	Parent root1;
	
	
	
	public void setRoot(Parent root1) {
		this.root1 = root1;
		
	}
	
	public void bookSearch() {
		TextField bookin = (TextField)root1.lookup("#bookIn");
		
		
		
		
		
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
		Parent root2=null;
		try {
			root2 = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root2);
		
		LoginController ctl = loader.getController();
		ctl.setRoot(root2);
		
		stage.setScene(scene);
		stage.show();
	}
	public void borrow() {
		
		
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirm_Catalog.fxml"));
		Parent root3=null;
		try {
			root3 = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root3);
		
		LoginController ctl = loader.getController();
		ctl.setRoot(root3);
		
		stage.setScene(scene);
		stage.show();
	}
	public void recomBook() {
		
	}
	public void logOut() {
		
	}
}
