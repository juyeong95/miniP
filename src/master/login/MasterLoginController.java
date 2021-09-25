package master.login;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import master.add.MasterAddMain;
import master.del.MasterDelMain;
import master.member.MasterMemberMain;
import master.mod.MasterModMain;

public class MasterLoginController implements Initializable{
	MasterModMain mmm;
	MasterDelMain mdm;
	MasterAddMain mam;
	MasterMemberMain mem;
	Parent root;
	DBCommon db;

	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mdm = new MasterDelMain();
		mmm = new MasterModMain();
		mam = new MasterAddMain();
		mem = new MasterMemberMain();
		db  = new DBCommon();
	}
	
	public void del() { //삭제
		mdm.getdel();
	}
	
	public void mod() { //수정
		mmm.getmod();
	}
	
	public void member() { //회원관리
		mem.getmember();
	}
	
	public void add() { //추가
		mam.getadd();
	}
	
	public void back() { //뒤로가기
		db.closeStage(root);
	}
}
