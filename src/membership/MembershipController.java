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
		mss.setRoot(root); //회원가입 초기창을 메인에서 전달받은 후 membershipservice로 다시 전달
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mss = new MembershipServiceImpl();
		
	}
	public void confirmBut() { //확인버튼
		mss.confirm();
	}
	public void cancelBut() { //취소버튼
		mss.cancel();
	}
}
