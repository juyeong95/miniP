package master.member;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memdto.MemDTO;

public class MasterMemberMod {
	public void mmm() {
		Stage stage = new Stage();   
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("memberMod.fxml"));
	       Parent root1 = null;
	       try {
				root1 = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			MasterMemberController mmmclt = loader.getController();
			mmmclt.setRoot(root1);
			
			MemDTO dto = new MemDTO();
			Scene scene = new Scene(root1);
	       
			stage.setScene(scene);
			stage.show();
	}
}
