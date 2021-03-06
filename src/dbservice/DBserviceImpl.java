package dbservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcommon.DBCommon;
import membership.MemberDTO;
import memdto.MemDTO;

public class DBserviceImpl implements DBService{
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
	@Override
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

}