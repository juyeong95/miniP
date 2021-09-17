package miniProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import membership.MembershipMain;
import seek.SeekMain;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.MyService;
import service.MyServiceImpl;

public class Controller implements Initializable{
		Parent root;
		MembershipMain msm;
		MyService ms;
		SeekMain sm;
		public void setRoot(Parent root) {
			this.root = root;
			ms.setRoot(root);
		}		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			ms = new MyServiceImpl();
			DBCommon.setDBConnection(); //연결
			msm = new MembershipMain();
			sm = new SeekMain();
		}
		public void loginBut() {
			ms.login();

		}
		public void seekBut() {
			sm.OpenSeek();
		}
		public void memberBut() {
			msm.OpenMembership(); //회원가입 완료
		}
		public void masterBut() {
			System.out.println("마스터");
		}
		
	
}
