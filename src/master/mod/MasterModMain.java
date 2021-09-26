package master.mod;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterModMain {

	public void getmod() {
		Stage mod = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mod.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterModController mmcl = loader.getController();
		mmcl.setRoot(root);
		
		mod.setScene(new Scene(root));
		mod.show();
	}
}
