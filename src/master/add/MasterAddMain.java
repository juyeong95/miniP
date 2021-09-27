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
			root = loader.load(); //추가버튼 누를 시 나오는 창 (add.fxml)
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterAddController macl = loader.getController(); //masteraddcontroller에 root값을 전달
		macl.setRoot(root);
		add.setScene(new Scene(root));
		add.show();
	}
}
