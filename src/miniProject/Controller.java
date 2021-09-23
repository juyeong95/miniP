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
<<<<<<< HEAD
import master.MasterMain;
import membership.MembershipMain;
=======
import membership.MembershipMain;
import seek.SeekMain;
>>>>>>> 015ce3136f6cfbfc839869cc37b4e880780c96b8
import service.MyService;
import service.MyServiceImpl;

public class Controller implements Initializable{
		Parent root;
		MembershipMain msm;
		MyService ms;
<<<<<<< HEAD
		MasterMain mm;
		MembershipMain msm;
=======
		SeekMain sm;
>>>>>>> 015ce3136f6cfbfc839869cc37b4e880780c96b8
		public void setRoot(Parent root) {
			this.root = root;
			ms.setRoot(root);
		}		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			ms = new MyServiceImpl();
			DBCommon.setDBConnection(); //연결
<<<<<<< HEAD
			mm = new MasterMain(); 
			msm = new MasterMain(); 
=======
			msm = new MembershipMain();
			sm = new SeekMain();
>>>>>>> 015ce3136f6cfbfc839869cc37b4e880780c96b8
			
		}
		public void loginBut() {
			ms.login();
		}
		public void seekBut() {
			sm.OpenSeek();
		}
		public void memberBut() {
			msm.OpenMembership();
		}
		public void masterBut() {
			System.out.println("마스터 버튼");
		}
		
	
}
