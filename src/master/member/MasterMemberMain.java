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
			root = loader.load(); //멤버 관리 초기 화면 (member.fxml)을 root값에 전달
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterMemberController mmcl = loader.getController(); //MasterMemberController에 root값을 전달
		mmcl.setRoot(root);
		member.setScene(new Scene(root));
		member.show();
	}
}
