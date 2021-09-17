package membership;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MembershipController implements Initializable{
	Parent root;
	MembershipService mss;
	
	public void setRoot(Parent root) {
		this.root=root;
		mss.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mss = new MembershipServiceImpl();
		
	}
	public void confirmBut() {
		mss.confirm();
	}
	public void cancelBut() {
		System.out.println("취소 버튼");
	}
}
