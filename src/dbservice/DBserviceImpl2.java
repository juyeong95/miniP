package dbservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcommon.DBCommon;
import memdto.BookDTO;
import memdto.MemDTO;

public class DBserviceImpl2 {
	
	
	public BookDTO loginCheck(String id1) {
		
		String sql = "select * from BOOK where title=?";
		BookDTO dto = null;
		try {
			PreparedStatement ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id1);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublish(rs.getString("publisher"));
				dto.setId(rs.getString("id"));
				dto.setBookNum(rs.getString("bookNum"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
		
	}

}
