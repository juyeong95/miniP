package dbservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcommon.DBCommon;
import memdto.MemDTO;

public class DBserviceImpl {
	
	
	public MemDTO loginCheck(String id) {
		
		String sql = "select * from MEMBER where id=?";
		MemDTO dto = null;
		try {
			PreparedStatement ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
		
	}

}
