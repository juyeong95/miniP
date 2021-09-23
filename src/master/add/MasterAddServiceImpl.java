package master.add;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MasterAddServiceImpl implements MasterAddService{
	ArrayList<MasterBookDTO> list = new ArrayList<MasterBookDTO>();
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void BookAdd() {
	}
	
	@Override
	public ArrayList<MasterBookDTO> BookList() {
		String sql =  "update book set booknum=?,name=?,phone=?where id=?";
		try {
			DBCommon.setDBConnection();
			PreparedStatement ps = DBCommon.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TextField bookNum = (TextField)root.lookup("#bookNum");
			TextField title = (TextField)root.lookup("#titleAdd");
			TextField author = (TextField)root.lookup("#authorAdd");
			TextField publisher = (TextField)root.lookup("#publisherAdd");
			TextField borrow = (TextField)root.lookup("#borrow");
			while(rs.next()	) {
				MasterBookDTO dto = new MasterBookDTO();
//		System.out.println("제목: " + title.getText());
//		System.out.println("저자: " + author.getText());
//		System.out.println("출판사: " + publisher.getText());
				dto.setBookNum(rs.getString("bookNum"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("Author"));
				dto.setPublisher(rs.getString("Publisher"));
				dto.setBorrow(rs.getString("Borrow"));
				
				list.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
