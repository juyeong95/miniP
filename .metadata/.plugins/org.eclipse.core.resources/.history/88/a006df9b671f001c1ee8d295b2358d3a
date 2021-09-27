package miniProject;

import java.io.IOException;
//
import java.util.Random;

import dbcommon.DBCommon;
//
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbcommon.DBCommon;
import dbservice.DBserviceImpl;
//
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

	
	DBCommon db1 = new DBCommon();

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
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	public void recomBook() {
		Random rand = new Random();
		
		
		String a[] = new String[15];
		for(int i=0;i<15;i++) {
			int ran4 = rand.nextInt(15)+1;
			String ra4 = ran4 + "";
			a[i] = ra4;
			
			for(int j=0; j<i; j++) {
				if(a[i].equals(a[j])) {
					i--;
				}
			}
			
		}
		
		BookDTO dto = db.bookRand(a[0]);
		BookDTO dto1 = db.bookRand(a[1]);
		BookDTO dto2 = db.bookRand(a[2]);
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("rand.fxml"));
		Parent root4=null;
		try {
			root4 = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label book1n = (Label)root4.lookup("#book1N");
		book1n.setText(dto.getTitle());
		Label book1a = (Label)root4.lookup("#book1A");
		book1a.setText(dto.getAuthor());
		Label book1p = (Label)root4.lookup("#book1P");
		book1p.setText(dto.getPublish());
		
		Label book2n = (Label)root4.lookup("#book2N");
		book2n.setText(dto1.getTitle());
		Label book2a = (Label)root4.lookup("#book2A");
		book2a.setText(dto1.getAuthor());
		Label book2p = (Label)root4.lookup("#book2P");
		book2p.setText(dto1.getPublish());
		
		Label book3n = (Label)root4.lookup("#book3N");
		book3n.setText(dto2.getTitle());
		Label book3a = (Label)root4.lookup("#book3A");
		book3a.setText(dto2.getAuthor());
		Label book3p = (Label)root4.lookup("#book3P");
		book3p.setText(dto2.getPublish());
		
		Scene scene = new Scene(root4);
		
		
		
		stage.setScene(scene);
		stage.show();
		
		

	}


	public void logOut() { //로그아웃 버튼
		Stage s = (Stage)root1.getScene().getWindow();
		s.close();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("이용해주셔서 감사합니다.");
		alert.show();
	}
	public void back() { // 대여목록 확인 - 뒤로가기 버튼
		Stage s = (Stage)root3.getScene().getWindow();
		s.close();

	}
	
	public void Return() {

		ComboBox<String> cmBook1 = (ComboBox<String>)root3.lookup("#cmbook");
		String s = cmBook1.getValue();
		try {
			//DBCommon.setDBConnection();
			PreparedStatement ps;
			ps=DBCommon.con.prepareStatement("update book set ID=null where title = '"+s+"'");
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("반납 되었습니다.");
			alert.show();
	}
}
