package master.add;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MasterAddController implements Initializable{
	ArrayList<MasterBookDTO> list;
	MasterAddService mas;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		mas.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mas = new MasterAddServiceImpl();
	}
	
	public void BookAdd() {  //책추가
		mas.BookAdd();
	} 
	
	public void Bookback() { //뒤로가기
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
