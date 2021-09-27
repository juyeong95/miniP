package seek;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import membership.MemberDTO;

public class FindpwdController implements Initializable{
	Parent root2;
	public void setRoot(Parent root2) {
		this.root2 = root2; //비밀번호 찾기 클릭시 화면
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public MemberDTO findpwd() { //dto 리턴값
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select * from member where id = ? and name = ? and phone = ?";
		
		TextField name = (TextField)root2.lookup("#findName");
		TextField phone = (TextField)root2.lookup("#findPN");
		TextField id = (TextField)root2.lookup("#findId");
		//아이디,비밀번호,전화번호를 차례대로 입력받는다.
		MemberDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id.getText());
			ps.setString(2, name.getText());
			ps.setString(3, phone.getText()); //입력한 값을 sql문에 입력
			rs = ps.executeQuery();
			if(rs.next()) { 
				dto = new MemberDTO();
				dto.setPwd(rs.getString("pwd"));
				//첫번째 행이 존재하면 dto값에 pwd값을 설정한다.
				//회원정보가 일치하는 값은 한 행이므로 한가지 값만 저장된다.
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto; //dto에 저장된 pwd값을 리턴
		
	}
	public void seekBut() {
		MemberDTO dto = findpwd(); //새로운 dto에 findpwd에서 받은 dto값을 전달
		if(dto != null) { //dto값이 존재한다면 실행
			DBCommon.getAlert("비밀번호 : " + dto.getPwd());
		}else { 
			DBCommon.getAlert("존재하지 않는 회원정보 입니다. 다시 확인해 주세요");
			//dto값이 존재하지 않는다면 실행
		}
	}
	public void exitBut() {
		DBCommon.closeStage(root2);
	}
}
