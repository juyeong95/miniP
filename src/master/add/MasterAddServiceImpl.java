package master.add;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MasterAddServiceImpl implements MasterAddService{
	PreparedStatement ps;
	Parent root;
	int result = 0;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	
	@Override
	public int BookAdd(MasterBookDTO dto) {  //책추가 dto
		String sql =  "insert into book values(?,?,?,?)";
	
			try {
				DBCommon.setDBConnection();
				ps = DBCommon.con.prepareStatement(sql);
				ps.setString(1, dto.getBookNum());
				ps.setString(2, dto.getTitle());
				ps.setString(3, dto.getAuthor());
				ps.setString(4, dto.getPublisher());
				int result = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public MasterBookDTO BookAdd1() {  //책 추가 dto에 담기
		TextField bookNum = (TextField)root.lookup("#bookNum");
		TextField title = (TextField)root.lookup("#titleAdd");
		TextField author = (TextField)root.lookup("#authorAdd");
		TextField publisher = (TextField)root.lookup("#publisherAdd");
//		System.out.println("bookNum : " + bookNum.getText());
//		System.out.println("title : " + title.getText());
//		System.out.println("author : " + author.getText());
//		System.out.println("publisher : " + publisher.getText());
		
		MasterBookDTO dto = new MasterBookDTO();
		dto.setBookNum(bookNum.getText());
		dto.setTitle(title.getText());
		dto.setAuthor(author.getText());
		dto.setPublisher(publisher.getText());
		
		return dto;
	}



	
}
