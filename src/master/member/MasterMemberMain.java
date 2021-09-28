package master.member;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterMemberMain {
	public void getmember() {
		Stage member = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("member.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterMemberController mmcl = loader.getController();
		mmcl.setRoot(root);
		member.setScene(new Scene(root));
		member.show();
	}
}
