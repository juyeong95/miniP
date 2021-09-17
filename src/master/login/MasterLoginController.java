package master.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import master.del.MasterDelMain;
import master.mod.MasterModMain;

public class MasterLoginController implements Initializable{
	MasterModMain mmm;
	MasterDelMain mdm;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mdm = new MasterDelMain();
		mmm = new MasterModMain();
		
	}
	
	public void del() { //삭제
		mdm.getdel();
	}
	public void mod() { //수정
		mmm.getmod();
	}
	public void member() { //회원관리
		
	}
	public void add() { //추가
		
	}
	public void back() { //뒤로가기
		
	}
	

}
