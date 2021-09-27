package master.del;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import master.add.MasterBookDTO;
import memdto.BookDTO;

public class MasterDelServiceImpl implements MasterDelService{
	Parent root;
	static String stt; 
	int result = 0;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	public void identify() { //확인 버튼
		TextField bookNum =(TextField)root.lookup("#masterDelNum");
		
		stt=bookNum.getText();
		//책번호를 textfield로 받아서 전역변수 stt에 책번호를 저장한다.
		MasterBookDTO dto = getDelList(stt);
		//전역변수로 받은 stt를 통해서 dto값을 저장한다.
		if(dto != null) { //데이터베이스에 저장 된 책 번호를 입력 시 dto값이 저장되고 없을 시 null값이며 null값이 아닐 때 실행
		TextArea content = (TextArea)root.lookup("#masterDelContent");
		content.setText(dto.getBookNum()+"\n"+dto.getTitle()+"\n"+dto.getAuthor()+"\n"+dto.getPublisher());
		//textarea를 root값을 통해 받아온 후 dto값을 \n과 함께 사용하여 textarea값을 저장
		} else { //데이터베이스에 저장 되지 않은 값을 입력했을 때 실행
			DBCommon.getAlert("입력하신 번호가 없습니다.");
		}
		
	}
	public void masterDel() { //삭제 버튼
		
		DBCommon.setDBConnection();
		PreparedStatement ps;
		
		try {
			ps = DBCommon.con.prepareStatement("delete from book where bookNum = '"+stt+"'");
			result = ps.executeUpdate();
			
			//전 단계에서 받은 전역변수 stt(책 번호)를 이용하여 데이터베이스에 저장된 열을 삭제한다.
			//성공 시 result에 1을 저장 실패 시 0을 저장
			if(result == 1) { 
				DBCommon.getAlert("삭제 성공");
			}else {
				DBCommon.getAlert("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public MasterBookDTO getDelList(String bookNum) { //책번호를 받아서 DTO값을 리턴해주는 기능
		MasterBookDTO dto = null;
		
		try {
			
			String sql = "select * from book where bookNum=?";
			DBCommon.setDBConnection();
			PreparedStatement ps;
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, bookNum);
			//booknum에 stt값이 전달 된 상태이며 ?값에 stt값을 저장
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MasterBookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setBookNum(rs.getString("bookNum"));
				//책 번호는 기본키 이므로 중복될 수 없고 첫 행이 있는지 확인한 후 정보를 dto값에 저장한다.
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return dto;
	}
	
	
	
	
}
