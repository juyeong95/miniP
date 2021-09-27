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
	Parent root1;
	MasterModService mms;
	int result;
	public void setRoot(Parent root) {
		this.root = root;
		mms.setRoot(root); //수정 첫화면을 root값으로 전달 받고 MasterModService에 root값을 전달
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
		//modify를 통해 result값을 전달받았고 getmodify를 통해 modify에 dto값을 전달한다
		if(result == 1) {
			DBCommon.getAlert("수정 성공");
		}else {
			DBCommon.getAlert("수정 실패");
		}
	}
	
	public void back2() { //취소버튼
		DBCommon.closeStage(MasterModService.root1);
		//창닫기
		MasterModService.dto = null; 
		//dto값이 한번 저장되면 취소를 누르고 없는 booknum을 넣어도 계속 dto값이 남아있기 때문에 
		//취소버튼을 눌러서 창을 나갈 시 dto를 초기화한다.
	}


	
}
