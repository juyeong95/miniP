package master.del;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcommon.DBCommon;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import master.add.MasterBookDTO;
import memdto.BookDTO;

public class MasterDelServiceImpl implements MasterDelService{
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public MasterBookDTO getDelList(String bookNum) {
		MasterBookDTO dto = null;
		try {
			
			String sql = "select * from book where bookNum=?";
			DBCommon.setDBConnection();
			PreparedStatement ps;
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, bookNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MasterBookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setBookNum(rs.getString("bookNum"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return dto;
	}
	
	
	
	
}
