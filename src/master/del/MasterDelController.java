package master.del;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import master.add.MasterBookDTO;

public class MasterDelController implements Initializable{
	MasterDelService mds;
	Parent root;
	static String stt;

	int result = 0;
	public void setRoot(Parent root) {
		this.root = root;
		mds.setRoot(root); //삭제화면 root를 받고 MasterDelService로 전달
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mds = new MasterDelServiceImpl();
	}
	
	public void identify() {  //확인버튼
		mds.identify();
		
	}
	public void masterDel() {  //삭제버튼
		mds.masterDel();
		
	}
	public void masterDelBack() { //뒤로가기
		DBCommon.closeStage(root);
	}
}
