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
			root = loader.load(); //삭제버튼 클릭 시 초기화면을 (del.fxml) root에 전달
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterDelController mdcl = loader.getController(); //root값을 MasterDelController에 전달
		mdcl.setRoot(root);
		del.setScene(new Scene(root));
		del.show();
	}
}
