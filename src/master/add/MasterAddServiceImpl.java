package master.add;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MasterAddServiceImpl implements MasterAddService{
	Parent root;
	int result = 0;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	
	@Override
	public int BookAdd(MasterBookDTO dto) {  //책추가 기능 (dto값을 받은 후 결과값을 int로 전달)
		String sql =  "insert into book(booknum,title,author,publisher) values(?,?,?,?)";
		
			try {
				DBCommon.setDBConnection();
				PreparedStatement ps;
				ps = DBCommon.con.prepareStatement(sql);
				ps.setString(1, dto.getBookNum());
				ps.setString(2, dto.getTitle());
				ps.setString(3, dto.getAuthor());
				ps.setString(4, dto.getPublisher());
				
				//boookadd1에서 리턴받은 dto값을 통해 insert문에 있는 ?에 값을 하나씩 전달한다
				result = ps.executeUpdate();
				//성공 시 1, 실패 시 0을 result값에 저장
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public MasterBookDTO BookAdd1() {  //dto에 값을 전달하고 리턴
		TextField bookNum = (TextField)root.lookup("#bookNum");
		TextField title = (TextField)root.lookup("#titleAdd");
		TextField author = (TextField)root.lookup("#authorAdd");
		TextField publisher = (TextField)root.lookup("#publisherAdd");
		
		
		MasterBookDTO dto = new MasterBookDTO();
		dto.setBookNum(bookNum.getText());
		dto.setTitle(title.getText());
		dto.setAuthor(author.getText());
		dto.setPublisher(publisher.getText());
		//dto값을 새로 선언 한 후 root값을 통해 전달받은 텍스트필드를 통해 값을 입력 받은 후 dto에 값 전달
		
		return dto;
	}



	
}
