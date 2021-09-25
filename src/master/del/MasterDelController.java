package master.del;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import master.add.MasterBookDTO;

public class MasterDelController implements Initializable{
	MasterDelService mds;
	Parent root;
	static String stt;
	int result = 0;
	public void setRoot(Parent root) {
		this.root = root;
		mds.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mds = new MasterDelServiceImpl();
	}
	
	public String identify() {  //확인버튼
		TextField bookNum =(TextField)root.lookup("#masterDelNum");
		String st = bookNum.getText();
		stt=bookNum.getText();
		MasterBookDTO dto = mds.getDelList(st);
		TextArea content = (TextArea)root.lookup("#masterDelContent");
		content.setText(dto.getBookNum()+"\n"+dto.getTitle()+"\n"+dto.getAuthor()+"\n"+dto.getPublisher());
		
		return st;
	}
	public void masterDel() {  //삭제버튼
		String st = identify();
		DBCommon.setDBConnection();
		PreparedStatement ps;
	
		try {
			ps = DBCommon.con.prepareStatement("delete from book where bookNum = '"+stt+"'");
			result = ps.executeUpdate();
			
			if(result == 1) {
				DBCommon.getAlert("삭제 성공");
			}else {
				DBCommon.getAlert("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void masterDelBack() { //뒤로가기
		DBCommon.closeStage(root);
	}
}
