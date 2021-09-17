package seek;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeekController implements Initializable{
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void findidBut() {
		Stage findidStage = new Stage();
		FXMLLoader loader = new FXMLLoader( getClass().getResource("findid.fxml") );
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		FindidController fc = loader.getController();
		fc.setRoot(root);
		
		findidStage.setScene(scene);
		findidStage.show();
	}
	public void findpwdBut() {
		Stage findpwdStage = new Stage();
		FXMLLoader loader1 = new FXMLLoader( getClass().getResource("findpwd.fxml") );
		Parent root1 = null;
		try {
			root1 = loader1.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene1 = new Scene(root1);
		
		FindpwdController fpc = loader1.getController();
		fpc.setRoot(root1);
		
		findpwdStage.setScene(scene1);
		findpwdStage.show();
	}
	public void exitBut() {
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
