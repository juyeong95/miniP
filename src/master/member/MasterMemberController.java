package master.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MasterMemberController implements Initializable{

	Parent root;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void memberSearch() {}
	public void memberBack() {
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
