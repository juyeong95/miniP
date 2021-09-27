package membership;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MembershipMain {
	public void OpenMembership() {
		Stage membershipStage = new Stage();
		FXMLLoader loader = new FXMLLoader( getClass().getResource("membership.fxml") );
		Parent root = null;
		try {
			root=loader.load(); //회원가입 버튼을 눌렀을 때 나오는 창 membership.fxml을 root값에 전달
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		MembershipController msc = loader.getController(); //root값을 membershipcontroller에 전달
		msc.setRoot(root);
		
		membershipStage.setScene(scene);
		membershipStage.show();
	}
}
