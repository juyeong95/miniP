package master;

import java.net.URL;
import java.util.ResourceBundle;

import alert.alert;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import master.login.MasterLoginMain;
import memdto.MemDTO;

public class MasterController implements Initializable{
	MasterLoginMain mlm;
	Parent root;
	@FXML
	private Button mlogin;
	
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mlm = new MasterLoginMain();
	}
	
	public void masterLogin() {  //마스터 login onAction
		MemDTO dto = new MemDTO();
		dto.setId("master");//마스터 로그인을 위한 아이디 "master"로 설정
		dto.setPwd("master");
		TextField id = (TextField) root.lookup("#masterId");//텍스트필드의 입력값 불러오기
		PasswordField pwd = (PasswordField) root.lookup("#masterPwd");

		if(dto.getId().equals(id.getText())) {//입력값과 마스터 로그인을 위한 아이디 및 비밀번호 확인 
			if(dto.getPwd().equals(pwd.getText())) {
				MasterMain mm = new MasterMain();
				//id와 pwd가 맞았을 경우 			
			    mlm.getFrom();
			    alert.getAlert("Welcome Sir.");
				closeStage();
			}else alert.getAlert("login fail");
		}else alert.getAlert("login fail");
	}
	
	public void masterBack() {	  //마스터 뒤로가기 onAction
		
	}
	
	public void closeStage() {
		Stage stage = (Stage) mlogin.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
	}
}

