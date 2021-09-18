package master.add;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterAddMain {
	public void getadd() {
		Stage add = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterAddController macl = loader.getController();
		macl.setRoot(root);
		add.setScene(new Scene(root));
		add.show();
	}
}
