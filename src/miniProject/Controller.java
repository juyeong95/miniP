package miniProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller implements Initializable{
		Parent root;
		public void setRoot(Parent root) {
			this.root = root;
		}		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			DBCommon.setDBConnection(); //연결
			
		}
		public void loginBut() {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root1=null;
			try {
				root1 = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scene scene = new Scene(root1);
			
			LoginController ctl = loader.getController();
			ctl.setRoot(root1);
			
			stage.setScene(scene);
			stage.show();
		}
		public void seekBut() {
			System.out.println("찾기 버튼");
		}
		public void memberBut() {
			System.out.println("회원가입 버튼");
		}
		public void masterBut() {
			System.out.println("마스터 버튼");
		}
		
	
}
