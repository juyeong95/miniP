package master.del;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MasterDelController implements Initializable{
	MasterDelService mds; 
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mds = new MasterDelServiceImpl();
	}
	
	public void delClick() {  //책 삭제 버튼
		mds.getDelete();
	}
	
	public void delBack() {   //뒤로가기 버튼
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
