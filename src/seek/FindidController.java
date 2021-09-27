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

public class FindidController implements Initializable{
	Parent root1;
	
	public void setRoot(Parent root1) {
		this.root1=root1; //아이디찾기 버튼 클릭시 화면
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public MemberDTO findid() { //dto 리턴값
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select * from member where name = ? and phone = ?";
		
		TextField name = (TextField)root1.lookup("#findName");
		TextField phone = (TextField)root1.lookup("#findPN");
		//이름과 휴대폰번호를 입력받는다
		MemberDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, name.getText());
			ps.setString(2, phone.getText());
			//where절에 입력받은 이름과 휴대폰번호를 넣어서 값을 찾는다
			rs = ps.executeQuery();
			if(rs.next()) { 
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				//첫번째 행이 존재하면 dto값에 id값을 설정한다.
				//회원정보가 일치하는 값은 한 행이므로 한가지 값만 저장된다.
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto; //dto에 저장된 id값을 리턴
		
	}
	public void findBut() { //찾기 버튼
		MemberDTO dto = findid(); //새로운 dto에 findid에서 받은 dto값을 전달
		if(dto != null) {//dto값이 존재한다면 실행
			DBCommon.getAlert("아이디: " + dto.getId());//DBCommon에 getAlert공통기능 사용
		}else {
			DBCommon.getAlert("존재하지 않는 회원정보 입니다. 다시 확인해 주세요"); 
			//dto값이 존재하지 않는다면 실행
		}
		
	}
	public void exitBut() {
		DBCommon.closeStage(root1);
	}
}
