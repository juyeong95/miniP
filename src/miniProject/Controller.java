package miniProject;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import master.MasterMain;
import membership.MembershipMain;
import seek.SeekMain;
import service.MyService;
import service.MyServiceImpl;

public class Controller implements Initializable{
		MasterMain mm;
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
			mm = new MasterMain(); //masterMain 객체 생성	
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
			mm.getMasterLogin();
			System.out.println("마스터");
		}
		
	
}
