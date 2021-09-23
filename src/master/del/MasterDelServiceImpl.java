package master.del;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbcommon.DBCommon;
import javafx.scene.Parent;

public class MasterDelServiceImpl implements MasterDelService{
	PreparedStatement ps;
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void getDelete() {
		String sql = "delete from book where bookNum=?";
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
