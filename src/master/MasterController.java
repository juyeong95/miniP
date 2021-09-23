package master;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import master.login.MasterLoginMain;

public class MasterController implements Initializable{
	MasterLoginMain mlm;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mlm = new MasterLoginMain();
		
	}
	
	
	public void masterLogin() {  //마스터 login onAction
		mlm.getFrom();
	}
	
	public void masterBack() {	  //마스터 뒤로가기 onAction
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
	
}
