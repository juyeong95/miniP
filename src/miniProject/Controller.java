package miniProject;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import membership.MembershipMain;



public class Controller implements Initializable{
		Parent root;
		MembershipMain msm;
		public void setRoot(Parent root) {
			this.root = root;
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			DBCommon.setDBConnection(); //연결
			msm = new MembershipMain();
		}
		public void loginBut() {
			
		}
		public void seekBut() {
			System.out.println("찾기 버튼");
		}
		public void memberBut() {
			msm.OpenMembership(); //회원가입 완료
		}
		public void masterBut() {
			System.out.println("마스터 버튼");
		}
}
