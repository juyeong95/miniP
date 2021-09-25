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
		mas.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mas = new MasterAddServiceImpl();
	}
	
	public void BookAdd() {  //책추가
		result = mas.BookAdd(mas.BookAdd1());
		
		System.out.println();
		if(result == 1) {
			DBCommon.getAlert("저장 성공!!");
		}else {
			DBCommon.getAlert("저장 실패!!");
		}
		
	} 
	
	public void Bookback() { //뒤로가기
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
