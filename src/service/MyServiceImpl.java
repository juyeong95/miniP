package service;

import java.io.IOException;

import dbcommon.DBCommon;
import dbservice.DBserviceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import memdto.MemDTO;
import miniProject.LoginController;

public class MyServiceImpl implements MyService{
	public static String idid;
	Parent root;
	
	DBserviceImpl db = new DBserviceImpl();
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	//로그인 버튼 구현

	@Override
	public void login() {
		
		TextField txid = (TextField)root.lookup("#id");
		PasswordField txpw = (PasswordField)root.lookup("#pwd");
		
		
		MemDTO dto = db.loginCheck(txid.getText()); //DBserviceImpl.logincheck에 txid값을 전달해 dto값을 리턴해온다.
		
		
		
		
		if(dto != null) { //dto가 null값이 아닐때 실행(정상적으로 받아왔다면 값을 갖고 있다.)
			if(dto.getPwd().equals(txpw.getText())) { 
				//dto값에서 pwd값을 가져오고(데이터베이스 아이디값에 저장된 패스워드값) 입력된 패스워드와 같은지 확인 후 맞으면 실행
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproject/login.fxml"));
				Parent root1=null;
				try {
					root1 = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				idid=dto.getId();
				Scene scene = new Scene(root1);
				
				LoginController ctl = loader.getController();
				ctl.setRoot(root1);  //LoginController에 root1(login.fxml)을 전달한다.
				
				txpw.clear();
				
				stage.setScene(scene);
				stage.show();
				
			}
			else { //dto값에서 pwd값을 가져오고(데이터베이스 아이디값에 저장된 패스워드값) 입력된 패스워드와 같은지 확인 후 틀리면 실행
				if(txpw.getText().isEmpty()) {//비밀번호 입력창이 비어있다면 실행
					DBCommon.getAlert("비밀번호를 입력해 주세요");
					txpw.requestFocus();
					
				}else { //비밀번호 입력창에 값이 있지만 dto에 저장된 비밀번호와 다르므로 실행
					DBCommon.getAlert("비밀번호가 틀렸습니다");
					txpw.requestFocus();
					txpw.clear();
				
				}
			}
		} else { //dto값이 null값일때
			if(txid.getText().isEmpty()) { //아이디가 입력되지 않았다면 실행
				DBCommon.getAlert("아이디를 입력해주세요");
			}else { //id가 입력되었지만 dto값을 리턴받지 못했으므로 입력된 아이디가 데이터베이스에 입력된값에 없다.
				DBCommon.getAlert("등록되지 않은 아이디 입니다.");
				txid.requestFocus();
				txpw.clear();
				
			}
			
		
		}
		
		
		
	}
	
	

}