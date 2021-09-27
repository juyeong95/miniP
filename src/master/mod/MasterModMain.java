package master.mod;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterModMain {

	public void getmod() { //
		Stage mod = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mod.fxml"));
		Parent root = null;
		try {
			root = loader.load(); //수정 첫번째 화면 (mod.fxml)을 root값에 전달
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterModController mmcl = loader.getController(); //MasterModController에 root값을 전달
		mmcl.setRoot(root);
		
		mod.setScene(new Scene(root));
		mod.show();
	}
}
