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
	static MasterBookDTO dto = null;
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
			root1 = loader.load(); //책 번호를 입력 시 뜨는 수정화면 modctl.fxml을 root1로 전달
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		stage.setScene(new Scene(root1));
		stage.show();
	}
	
	
	
	public void book1() { //검색버튼을 눌렀을때
		TextField bNum = (TextField)root.lookup("#modBook");
		dto = bookSearch(bNum.getText());
		//수정 첫 페이지에 있는 textfield를 이용해 책번호를 booksearch에 전달하여 dto값을 가져온다.
		if(dto == null) { //dto가 null값을 가져오면 실행
			if(bNum.getText().isEmpty()) { //전의 root에서 아무것도 입력하지 않으면 실행
			DBCommon.getAlert("책번호를 입력해 주세요!");
			} else { //전의 root에서 값을 입력했지만 데이터베이스에 책넘버가 없을때 실행
				DBCommon.getAlert("책번호가 잘못 입력되었습니다.");
			}
		}else { //유효한 책넘버를 입력해 dto값을 가져왔을때 실행
			stage2();//새로운 root1(modctl.fxml)창이 띄워진다
			Label bookNumber = (Label)root1.lookup("#bookNum");
			Label exName = (Label)root1.lookup("#exName");
			Label exAuthor = (Label)root1.lookup("#exAuthor");
			Label exPublisher = (Label)root1.lookup("#exPublisher");
			//root1에 있는 라벨들을 정의한다
			
			exName.setText(dto.getTitle());
			exAuthor.setText(dto.getAuthor());
			exPublisher.setText(dto.getPublisher());
			bookNumber.setText(dto.getBookNum());
			//라벨의 값들을 받아온 dto값으로 변환한다
		}
	}
	
	public int modify(BookDTO dto) { //dto값을 받아 result값을 리턴한다
		DBCommon.setDBConnection();
		String spl = "update book set title=?,author=?,publisher=? where bookNum=?";
		try {
			ps = DBCommon.con.prepareStatement(spl);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getAuthor());
			ps.setString(3, dto.getPublish());
			ps.setString(4, dto.getBookNum());
			//booknum을 통해 행을 찾고 넘겨받은 dto값을 통하여 update한다
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; //성공 시 1 실패 시 0을 리턴한다.
	}
	
	public BookDTO getmodify() { //bookdto를 설정 후 리턴(새로운 값을 입력받아 수정하는데 사용)
		BookDTO dto = new BookDTO();
		Label bookNum1 = (Label)root1.lookup("#bookNum");
		TextField title1 = (TextField)root1.lookup("#name");
		TextField author1 = (TextField)root1.lookup("#author");
		TextField publisher1 = (TextField)root1.lookup("#publisher");
		//root1을 통해 라벨과 텍스트필드값을 가져온다
		
		dto.setBookNum(bookNum1.getText());
		dto.setTitle(title1.getText());
		dto.setAuthor(author1.getText());
		dto.setPublish(publisher1.getText());
		//dto값에 기존에 있던 라벨(북넘버)와 새로 입력받은 이름,저자,출판사를 저장한다
		
		return dto;
	}
	
	public MasterBookDTO bookSearch(String bookNum) { 
		//책 번호값을 전달받아 dto값을 리턴한다 (기존에 있는 내용을 데이터베이스에서 가져와서 전달)
		String sql = "select * from book where bookNum=?";
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, bookNum);
			//book1에서 넘겨준 책넘버를 이용하여 행을 가져온다
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MasterBookDTO();
				dto.setBookNum(rs.getString("bookNum"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				
				//책넘버는 기본키이므로 중복되는 값이 올 수 없으므로 한 행만 값이 저장된다
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}











