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
import master.MasterMain;
import membership.MembershipMain;
import service.MyService;
import service.MyServiceImpl;

public class Controller implements Initializable{
		Parent root;
		MyService ms;
		MasterMain mm;
		MembershipMain msm;
		public void setRoot(Parent root) {
			this.root = root;
			ms.setRoot(root);
		}		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			ms = new MyServiceImpl();
			DBCommon.setDBConnection(); //연결
			mm = new MasterMain(); 
			msm = new MasterMain(); 
			
		}
		public void loginBut() {
			ms.login();
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
