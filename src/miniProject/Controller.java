package miniProject;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

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
			System.out.println("로그인 버튼");
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
		
		Parent root1;
		   public void setRoot1(Parent root1) {
		      this.root1 = root1;
		      
		   }
		   
		   public void bookSearch() {
		      
		   }
		   public void borrow() {
		      
		   }
		   public void recomBook() {
		      
		   }
		   public void logOut() {
		      
		   }
}
