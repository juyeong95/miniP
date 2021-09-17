package master.del;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterDelMain {
	

	public void getdel() {
		Stage del = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("del.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterDelController mdcl = loader.getController();
		mdcl.setRoot(root);
		del.setScene(new Scene(root));
		del.show();
	}
}
