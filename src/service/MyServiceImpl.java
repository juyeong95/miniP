package service;

import java.io.IOException;

import dbservice.DBServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import memdto.MemDTO;
import miniProject.LoginController;

public class MyServiceImpl implements MyService{
	
	Parent root;
	
	DBServiceImpl db = new DBServiceImpl();
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void login() {
		
		TextField txid = (TextField)root.lookup("#id");
		TextField txpw = (TextField)root.lookup("#pwd");
		
		MemDTO dto = db.loginCheck(txid.getText());
		System.out.println(dto);
		
		
		if(dto != null) {
			if(dto.getPwd().equals(txpw.getText())) {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproject/login.fxml"));
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
			else {
				if(txpw.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("비밀번호를 입력해주세요.");
					alert.show();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("비밀번호가 틀렸습니다.");
					alert.show();
				}
			}
		} else {
			if(txid.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("아이디를 입력해주세요.");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("등록되지 않은 아이디 입니다.");
				alert.show();
			}
			
		
		}
		
		
		
	}

}
