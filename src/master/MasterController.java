package master;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import master.login.MasterLoginMain;

public class MasterController implements Initializable{
	MasterLoginMain mlm;
	Parent root;
	@FXML
	private Button mlogin;
	DBCommon db = new DBCommon();

	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mlm = new MasterLoginMain();
	}
	
	public void masterLogin() {  //마스터 login onAction
		TextField id = (TextField) root.lookup("#masterId");//텍스트필드의 입력값 불러오기
		PasswordField pwd = (PasswordField) root.lookup("#masterPwd");

		if(id.getText().equals("master")) {	//마스터 로그인을 위한 아이디와 비밀번호를 미리 회원등록하고 "master"로 설정
			if(pwd.getText().equals("master")) {
				MasterMain mm = new MasterMain();
				//id와 pwd가 맞았을 경우 	
			    mlm.getFrom();
			    db.getAlert("Welcome Sir.");
			    db.closeStage(root);
				}else db.getAlert("login fail");
		}else db.getAlert("login fail");
	}
	
	public void masterBack() {	  //마스터 뒤로가기 onAction
		db.closeStage(root);
	}
}

