package master.member;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import master.del.MasterDelMain;
import master.mod.MasterModMain;
import memdto.MemDTO;
import miniProject.LoginController;

public class MasterMemberController implements Initializable{
	DBCommon db = new DBCommon();
	Parent root;
	MasterDelMain mdm = new MasterDelMain();
	MasterModMain mmm = new MasterModMain();
	Parent root2 = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void memberSearch() {
		TextField searchId = (TextField)root.lookup("#memberSearchId");
				
				MemDTO dto = memCheck(searchId.getText());	
				if(dto != null) {			
					Stage stage = new Stage();	
					FXMLLoader loader = new FXMLLoader(getClass().getResource("memList.fxml"));
					try {
						root2 = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Label lb1 = (Label)root2.lookup("#brLabel");
					Label lb12 = (Label)root2.lookup("#brLabel2");
					Label lb13 = (Label)root2.lookup("#brLabel3");
					
					lb1.setText(dto.getId());
					lb12.setText(dto.getName());
					lb13.setText(dto.getPhone());
					
					Scene scene = new Scene(root2);
					
					LoginController ctl = loader.getController();
					ctl.setRoot(root2);
					
					stage.setScene(scene);
					stage.show();
					
				} else {
					db.getAlert("존재하지 않는 ID입니다.");
				}
	}
	
	public void memberBack() {
		db.closeStage(root);
	}
	
	public MemDTO memCheck(String id) {
		String sql = "select * from MEMBER where id=?";
		MemDTO dto = null;
		try {
			PreparedStatement ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return dto;	
	}
	
	public void del() {
		mdm.getdel();
	}
	
	public void mod() {
		mmm.getmod();
	}
	
	public void back() {
		db.closeStage(root2);
	}
}
