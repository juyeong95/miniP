package dbservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcommon.DBCommon;
import membership.MemberDTO;

public class DBServiceImpl implements DBService{
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public int insertMember(MemberDTO dto) {
		String sql = "insert into member values(?,?,?,?)";
		int result=0;
		try {
			ps=DBCommon.con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getpNumber());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

}
