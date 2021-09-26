package master.mod;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import master.add.MasterBookDTO;

public class MasterModController implements Initializable{

	Parent root;
	MasterModService mms;
	int result;
	public void setRoot(Parent root) {
		this.root = root;
		mms.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mms = new MasterModService();
	}
	
	public void bookSearch() {  //북넘버 검색하기
		mms.book1();
	}
	public void back() {        //뒤로가기
		DBCommon.closeStage(root);
	}
	public void modify() {      //수정하기
		result = mms.modify(mms.getmodify());
		if(result == 1) {
			DBCommon.getAlert("수정 성공");
		}else {
			DBCommon.getAlert("수정 실패");
		}
	}
	
	public void back2() {
		DBCommon.closeStage(root);
	}


	
}
