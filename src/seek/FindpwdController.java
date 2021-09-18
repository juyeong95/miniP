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
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public MemberDTO findpwd() {
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select * from member where id = ? and name = ? and phone = ?";
		TextField name = (TextField)root.lookup("#findName");
		TextField phone = (TextField)root.lookup("#findPN");
		TextField id = (TextField)root.lookup("#findId");
		MemberDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id.getText());
			ps.setString(2, name.getText());
			ps.setString(3, phone.getText());
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
		
	}
	public void seekBut() {
		MemberDTO dto = findpwd();
		if(dto != null) {
			String fPwd = dto.getPwd();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("비밀번호: "+fPwd);
			alert.show();
		}else {
			String fPwd = "존재하지 않는 회원정보 입니다. 다시 확인해 주세요";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(fPwd);
			alert.show();
		}
	}
	public void exitBut() {
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
}
