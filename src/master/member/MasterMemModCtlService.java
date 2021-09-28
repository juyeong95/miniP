package master.member;

import java.sql.PreparedStatement;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import memdto.MemDTO;

public class MasterMemModCtlService {
	static Parent root1;
	PreparedStatement ps;
	int rs = 0;
	MasterMemberController mmc = new MasterMemberController();

	public MemDTO getmodify() { //수정할 멤버의 DTO 세팅하기 
		MemDTO dto = new MemDTO();
		TextField name = (TextField)MasterMemberModController.root1.lookup("#name");
		TextField phone = (TextField)MasterMemberModController.root1.lookup("#phone");
	     TextField searchId = (TextField)MasterMemberController.root.lookup("#memberSearchId");

		dto.setName(name.getText());
		dto.setPhone(phone.getText());
		dto.setId(searchId.getText());
		
		return dto;
	}
	
	public int modify(MemDTO dto) { //수정하기 
		DBCommon.setDBConnection();
		String sql = "update member set name=?, phone=? where id=?";
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getId());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
