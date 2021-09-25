package master.login;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterLoginMain {

	public void getFrom() {  //수정,삭제,추가,회원관리 창
		Stage masterlogin = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("masterLogin.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasterLoginController mcl = loader.getController();
		mcl.setRoot(root);
	
		masterlogin.setScene(new Scene(root));
		masterlogin.show();
	}
}
