package seek;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeekMain {
	public void OpenSeek() { //아이디/비밀번호 찾기 버튼 클릭시 처음 화면
		Stage seekStage = new Stage();
		FXMLLoader loader = new FXMLLoader( getClass().getResource("seek.fxml") );
		Parent root = null;
		try {
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		SeekController sc = loader.getController(); //root값을 seekcontroller로 전달
		sc.setRoot(root);
		
		seekStage.setScene(scene);
		seekStage.show();
	}
}
