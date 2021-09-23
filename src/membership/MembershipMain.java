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
			root=loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		MembershipController msc = loader.getController();
		msc.setRoot(root);
		
		membershipStage.setScene(scene);
		membershipStage.show();
	}
}
