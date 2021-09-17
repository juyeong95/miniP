package seek;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class FindidController implements Initializable{
	Parent root;
	public void setRoot(Parent root) {
		this.root=root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void findBut() {
		
	}
	public void exitBut() {
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
