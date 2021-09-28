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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import memdto.BookDTO;
import memdto.MemDTO;
import service.MyServiceImpl;

public class LoginController {
   Parent root1;
   static Parent root4;
   static Parent root3;
   static Parent root2;
   static String ti;
   static String bn;
   DBserviceImpl2 db = new DBserviceImpl2();

   
   DBCommon db1 = new DBCommon();

   DBserviceImpl db2 = new DBserviceImpl();
   

   
   public void setRoot(Parent root1) {
	      this.root1 = root1; //MyServiceImpl에서 받아온 root1 = login.fxml (로그인 성공시 화면)
	   }
   
   public void bookSearch() { // 도서 검색 버튼
      
      TextField bookin = (TextField)root1.lookup("#bookIn");
      
      ArrayList<BookDTO> dto = null;
      dto = db.loginCheck2(bookin.getText());
      ArrayList<BookDTO> yn = db.yn(bookin.getText()); //대여 가능 불가능
      
      
      if(!dto.isEmpty()) { //dto값이 정상적으로 받아졌을 경우
      
         
         Stage st = new Stage();
         FXMLLoader lo = new FXMLLoader(getClass().getResource("slist.fxml"));
         root4=null;
         try {
            root4=lo.load();
         } catch (Exception e) {
            e.printStackTrace();
         }
         ListView lv = (ListView)root4.lookup("#bllist");
         ListView lvyn = (ListView)root4.lookup("#blyn");
         for(int i=0; i<dto.size();i++) {
         lv.getItems().addAll(dto.get(i).getTitle());
         lvyn.getItems().addAll(yn.get(i).getId());
         }
         Scene sc = new Scene(root4);
         LoginController c = lo.getController();
         c.setRoot(root4);
         
         st.setScene(sc);
         st.show();
         
      } else { //책 제목이 데이터베이스에 저장돼있지 않으므로 dto값을 받아오지 못했을때 실행
         Alert alert = new Alert(AlertType.ERROR);
         alert.setContentText("책 제목을 확인하세요.");
         alert.show();
      }
      
      
      
      
      
   }
   public void blinfor() { //검색창 도서 정보
      ListView lv = (ListView)root4.lookup("#bllist");
      String strItem = (String) lv.getSelectionModel().getSelectedItem();
      BookDTO dto = db.loginCheck(strItem);
      if(dto != null) {
      Stage stage = new Stage();
      
      FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
      root2=null;
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
      }else {
         Alert alert = new Alert(AlertType.ERROR);
         alert.setContentText("도서를 선택해주세요.");
         alert.show();
      }
   }
   public void blcancle() { //검색창 취소
      Stage s = (Stage)root4.getScene().getWindow();
      s.close();
   }
   public void rentBut() { //대여 버튼
      BookDTO dto = db.loginCheck(ti);
    //전역변수로 설정해놓은 ti(책 제목을 검색했을때 데이터베이스에서 가져온 정보를 입력한 책제목)을 통해 dto값을 새로 가져온다.
      //도서 검색했을때 입력한 책제목 값과 동일
      
      if(dto != null) { //dto에 저장된 id값이 null이라면 아직 대여되지 않은 책이므로 실행
         if(dto.getId() != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("\""+ti+"\""+" 은/는 현재 대여중입니다.");
            alert.show();
         }else {
            try {
            //DBCommon.setDBConnection();
            PreparedStatement ps;
            ps=DBCommon.con.prepareStatement("update book set ID='"+MyServiceImpl.idid+"' where BOOKNUM='"+bn+"'");
            //전 단계에서 bn값(책 넘버값)을 데이터베이스에서 받아왔으므로 where절에 bn값을 넣고 리스트를 가져온 후 
            //처음 로그인할때 전역변수로 설정한 MyServiceImpl.idid(id값)을 id에 넣는다.
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
         //처음 로그인했을때 받은 전역변수 MyServiceImpl.idid를 통해 데이터베이스에 저장된 행을 불러온다.
         //이때 book테이블에 있는 내가 로그인한 id값에 저장된 모든 값을 불러온다.
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            BookDTO dto = new BookDTO();
            dto.setTitle(rs.getString("title"));
            //dto를 새로 선언한 후 rs.getString("title")을 통해 내가 로그인한 id값이 저장된 title값을 dto에 저장한다
            list.add(dto);  //ArrayList에 dto값을 추가한다. rs.next()를 while문에 넣었으므로 다음값이 없을때까지 실행
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list; //dto값을 추가한 ArrayList를 반환한다.
   }
   
   public void borrow() { //대여목록 확인 버튼
      MemDTO dto3 = db2.loginCheck(MyServiceImpl.idid);
      ArrayList<BookDTO> list = cmbook(); //cmbook()에서 반환된 dto값을 추가한 ArrayList를 새로운 ArrayList에 저장
      
      
      Stage stage = new Stage();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirm_Catalog.fxml"));
      root3=null;
      try {
         root3 = loader.load(); //root3에 대여목록을 확인하는 Confirm_Catalog.fxml를 넣는다.
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Label lb = (Label)root3.lookup("#fxId"); //root3를 통해 라벨값을 가져온 후
      lb.setText(MyServiceImpl.idid+" 님"); //라벨의 텍스트를 처음 로그인했을때 받아온 id값으로 설정
      ComboBox<String> cmBook = (ComboBox<String>)root3.lookup("#cmbook");
    //root3에 있는 콤보박스를 선언한다
      
      if(cmBook != null) {
         for(int i = 0; i<list.size(); i++) { //반복문을 통해 list에 저장된 값만큼 반복실행
            cmBook.getItems().addAll(list.get(i).getTitle()); //cmbook에 i번째에 있는 dto의 책 제목값을 저장한다.
         }
      }
      
      Scene scene = new Scene(root3);
      
      
      
      stage.setScene(scene);
      stage.show();
   }
   public void recomBook() {
	      Random rand = new Random(); //랜덤함수 선언
	      
	      
	      String a[] = new String[60]; //배열의 크기를 책의 수 만큼 설정한다.
	      for(int i=0;i<60;i++) { //랜덤값을 int로 받아 string으로 변환하고 배열값에 배열크기만큼 저장한다.
	         int ran4 = rand.nextInt(60)+1;
	         String ra4 = ran4 + "";
	         a[i] = ra4;
	         
	         for(int j=0; j<i; j++) { //중복값 제거
	            if(a[i].equals(a[j])) {
	               i--;
	            }
	         }
	         
	      }
	      
	      BookDTO dto = db.bookRand(a[0]); //배열이 랜덤으로 저장됐으니 그중 3개만 뽑아서 데이터베이스에서 값을 dto로 가져온다
	      BookDTO dto1 = db.bookRand(a[1]);
	      BookDTO dto2 = db.bookRand(a[2]);
	      
	      Stage stage = new Stage();
	      FXMLLoader loader = new FXMLLoader(getClass().getResource("rand.fxml"));
	      Parent root4=null;
	      try {
	         root4 = loader.load(); //root4에 이달의 추천도서를 클릭했을때 나오는 rand.fxml을 넣는다.
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      //라벨의 값을 dto,dto1,dto2에 저장된 값으로 변경한다(책제목,저자,출판사)
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
   
   public void Return() { //반납하기 버튼

      ComboBox<String> cmBook1 = (ComboBox<String>)root3.lookup("#cmbook"); //root3에 있는 콤보박스값을 선언
      String s = cmBook1.getValue(); //콤보박스에 있는 항목을 선택했을때 값을 String s로 받아온다
      try {
         //DBCommon.setDBConnection();
         PreparedStatement ps;
         ps=DBCommon.con.prepareStatement("update book set ID=null where title = '"+s+"'");
       //String s에 받아온 값을 where절에 넣고 id값을 null로 변경
            ps.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
         }
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setContentText("반납 되었습니다.");
         alert.show();
   }
}