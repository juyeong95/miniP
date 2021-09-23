package miniProject;

import java.io.IOException;

import dbservice.DBserviceImpl2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import memdto.BookDTO;

public class LoginController {
	Parent root1;
	
	DBserviceImpl2 db = new DBserviceImpl2();
	
	
	
	public void setRoot(Parent root1) {
		this.root1 = root1;
		
	}
	
	public void bookSearch() {
		
TextField bookin = (TextField)root1.lookup("#bookIn");
		
		BookDTO dto = db.loginCheck(bookin.getText());
		
		
		
		if(dto != null) {
			
			
			
			Stage stage = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
			Parent root2=null;
			try {
				root2 = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Label lb1 = (Label)root2.lookup("#brLabel");
			Label lb12 = (Label)root2.lookup("#brLabel2");
			Label lb13 = (Label)root2.lookup("#brLabel3");
			
			lb1.setText(dto.getTitle());
			lb12.setText(dto.getAuthor());
			lb13.setText(dto.getPublish());
			
			Scene scene = new Scene(root2);
			
			LoginController ctl = loader.getController();
			ctl.setRoot(root2);
			
			stage.setScene(scene);
			stage.show();
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("책 제목을 확인하세요.");
			alert.show();
		}
		
		
		
		
		
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
