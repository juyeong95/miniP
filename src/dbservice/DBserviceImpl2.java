package dbservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
public ArrayList<BookDTO> loginCheck2(String id1) {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps = DBCommon.con.prepareStatement("select * from BOOK where title like '%"+id1+"%'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublish(rs.getString("publisher"));
				dto.setId(rs.getString("id"));
				dto.setBookNum(rs.getString("bookNum"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	}
public ArrayList<BookDTO> yn(String id1) { //대여 가능 불가능
	ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	
	try {
		PreparedStatement ps = DBCommon.con.prepareStatement("select * from BOOK where title like '%"+id1+"%'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			BookDTO dto = new BookDTO();
			if(rs.getString("id") != null) {
				dto.setId("대여 불가");
			}else {
				dto.setId("대여 가능");
			}
			
			list.add(dto);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}
	
	public BookDTO bookRand(String num) {
		
		
		System.out.println(num);
		String sql = "select * from BOOK where booknum=?";
		BookDTO dto = null;
		try {
			PreparedStatement ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublish(rs.getString("publisher"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
	}

}
