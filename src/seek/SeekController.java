package seek;

import java.net.URL;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeekController implements Initializable{
	Parent root;
	public void setRoot(Parent root) {
		this.root = root; //아이디 비밀번호찾기 초기 화면
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void findidBut() { //아이디찾기 버튼
		Stage findidStage = new Stage();
		FXMLLoader loader = new FXMLLoader( getClass().getResource("findid.fxml") );
		Parent root1 = null;
		try {
			root1 = loader.load(); //root1값을 아이디찾기 클릭시 나오는 findid.fxml로 입력
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root1);
		
		FindidController fc = loader.getController(); //findidcontroller에 root1값을 전달
		fc.setRoot(root1);
		
		findidStage.setScene(scene);
		findidStage.show();
	}
	public void findpwdBut() { //비밀번호찾기 버튼
		Stage findpwdStage = new Stage();
		FXMLLoader loader1 = new FXMLLoader( getClass().getResource("findpwd.fxml") );
		Parent root2 = null;
		try {
			root2 = loader1.load(); //root1값을 비밀번호찾기 클릭시 나오는 findpwd.fxml로 입력
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene1 = new Scene(root2);
		
		FindpwdController fpc = loader1.getController(); //findpwdcontroller에 root2값을 전달
		fpc.setRoot(root2);
		
		findpwdStage.setScene(scene1);
		findpwdStage.show();
	}
	public void exitBut() { //나가기 버튼
		DBCommon.closeStage(root);
	}
}
