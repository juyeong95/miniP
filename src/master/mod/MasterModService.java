package master.mod;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import master.MasterController;
import master.add.MasterBookDTO;
import memdto.BookDTO;

public class MasterModService {
	Parent root;
	MasterBookDTO dto = null;
	PreparedStatement ps;
	int result = 0;
	static Parent root1;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void stage2() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("modCtl.fxml"));
		try {
			this.root1 = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MasterModController mmc = loader.getController();
		mmc.setRoot(root1);
		stage.setScene(new Scene(root1));
		stage.show();
	}
	
	public MasterBookDTO bookSearch(String bookNum) {
		String sql = "select * from book where bookNum=?";
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, bookNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MasterBookDTO();
				dto.setBookNum(rs.getString("bookNum"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void book1() {
		TextField bNum = (TextField)root.lookup("#modBook");
		dto = bookSearch(bNum.getText());
		if(dto == null) {
			
			DBCommon.getAlert("책번호를 입력해 주세요!");
			
		}else {
			stage2();
			Label bookNumber = (Label)root1.lookup("#bookNum");
			Label exName = (Label)root1.lookup("#exName");
			Label exAuthor = (Label)root1.lookup("#exAuthor");
			Label exPublisher = (Label)root1.lookup("#exPublisher");
			
			
			exName.setText(dto.getTitle());
			exAuthor.setText(dto.getAuthor());
			exPublisher.setText(dto.getPublisher());
			bookNumber.setText(dto.getBookNum());
		}
	}
	
	public int modify(BookDTO dto) {
		DBCommon.setDBConnection();
		String spl = "update book set title=?,author=?,publisher=? where bookNum=?";
		try {
			ps = DBCommon.con.prepareStatement(spl);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getAuthor());
			ps.setString(3, dto.getPublish());
			ps.setString(4, dto.getBookNum());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public BookDTO getmodify() {
		BookDTO dto = new BookDTO();
		Label bookNum1 = (Label)root1.lookup("#bookNum");
		TextField title1 = (TextField)root1.lookup("#name");
		TextField author1 = (TextField)root1.lookup("#author");
		TextField publisher1 = (TextField)root1.lookup("#publisher");
		dto.setBookNum(bookNum1.getText());
		dto.setTitle(title1.getText());
		dto.setAuthor(author1.getText());
		dto.setPublish(publisher1.getText());
		
		return dto;
	}
	
}











