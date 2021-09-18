package master;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterMain {

	public void getMasterLogin() {
		Stage masterLogin = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("master.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterController mctl = loader.getController();
		mctl.setRoot(root);
		masterLogin.setScene(new Scene(root));
		masterLogin.show();
	}

}
