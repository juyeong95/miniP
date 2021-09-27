package master.add;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MasterAddController implements Initializable{
	ArrayList<MasterBookDTO> list;
	MasterAddService mas;
	Parent root;
	String bookNum,title,author,publisher;
	int borrow,result = 0;
	
	public void setRoot(Parent root) {
		this.root = root;
		mas.setRoot(root); //책 추가 버튼 누를 시 초기 화면을 root로 받고 MasterAddService에 root값 전달
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mas = new MasterAddServiceImpl();
	}
	
	public void BookAdd() {  //등록 버튼
		result = mas.BookAdd(mas.BookAdd1()); //bookadd에서 리턴받은 전달값을 새로운 result에 넣는다
		
		
		if(result == 1) { //성공 시 result = 1 실패 시 result = 0
			DBCommon.getAlert("저장 성공!!");
		}else {
			DBCommon.getAlert("저장 실패!!");
		}
		
	} 
	
	public void Bookback() { //뒤로가기
		DBCommon.closeStage(root);
	}
}
