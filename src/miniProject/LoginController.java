package miniProject;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbcommon.DBCommon;
import dbservice.DBserviceImpl;
import dbservice.DBserviceImpl2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import memdto.BookDTO;
import memdto.MemDTO;
import service.MyServiceImpl;

public class LoginController {
	Parent root1;
	static Parent root3;
	static String ti;
	static String bn;
	DBserviceImpl2 db = new DBserviceImpl2();
	DBserviceImpl db2 = new DBserviceImpl();
	
	
	public void setRoot(Parent root1) {
		this.root1 = root1;
		
	}
	
	public void bookSearch() { // 도서 검색 버튼
		
		TextField bookin = (TextField)root1.lookup("#bookIn");
		
		BookDTO dto = db.loginCheck(bookin.getText());
		
		
		
		if(dto != null) {
			
			
			Stage stage = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
			Parent root2=null;
			try {
				root2 = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Label lb1 = (Label)root2.lookup("#brLabel");
			Label lb12 = (Label)root2.lookup("#brLabel2");
			Label lb13 = (Label)root2.lookup("#brLabel3");
			
			lb1.setText(dto.getTitle());
			lb12.setText(dto.getAuthor());
			lb13.setText(dto.getPublish());
			ti = dto.getTitle();
			bn=dto.getBookNum();
			Scene scene = new Scene(root2);
			
			LoginController ctl = loader.getController();
			ctl.setRoot(root2);
			
			stage.setScene(scene);
			stage.show();
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("책 제목을 확인하세요.");
			alert.show();
		}
		
		
		
		
		
	}
	public void rentBut() { //대여 버튼
		BookDTO dto = db.loginCheck(ti);
		//BookDTO dto2 = db.loginCheck(bn);
		//MemDTO dto3 = db2.loginCheck(MyServiceImpl.idid);
		
		if(dto != null) { 
			if(dto.getId() != null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("\""+ti+"\""+" 은/는 현재 대여중입니다.");
				alert.show();
			}else {
				try {
				//DBCommon.setDBConnection();
				PreparedStatement ps;
				ps=DBCommon.con.prepareStatement("update book set ID='"+MyServiceImpl.idid+"' where BOOKNUM='"+bn+"'");
					
					ps.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("대여 완료");
				alert.show();
			}
			
		}
	}
	public ArrayList<BookDTO> cmbook() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			PreparedStatement ps;
			ps = DBCommon.con.prepareStatement("select * from book where id='"+MyServiceImpl.idid+"'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void borrow() { //대여목록 확인 버튼
		MemDTO dto3 = db2.loginCheck(MyServiceImpl.idid);
		ArrayList<BookDTO> list = cmbook();
		
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirm_Catalog.fxml"));
		root3=null;
		try {
			root3 = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label lb = (Label)root3.lookup("#fxId");
		lb.setText(MyServiceImpl.idid+" 님");
		ComboBox<String> cmBook = (ComboBox<String>)root3.lookup("#cmbook");
		
		if(cmBook != null) {
			for(int i = 0; i<list.size(); i++) {
				cmBook.getItems().addAll(list.get(i).getTitle());
			}
		}
		
		Scene scene = new Scene(root3);
		
		LoginController ctl = loader.getController();
		ctl.setRoot(root3);
		
		stage.setScene(scene);
		stage.show();
	}
	public void recomBook() {
		
	}
	public void logOut() { //로그아웃 버튼
		Stage s = (Stage)root1.getScene().getWindow();
		s.close();
	}
	public void back() { // 대여목록 확인 - 뒤로가기 버튼
		Stage s = (Stage)root3.getScene().getWindow();
		s.close();
	}
}
