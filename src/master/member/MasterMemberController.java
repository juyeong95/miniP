package master.member;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dbcommon.DBCommon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import master.del.MasterDelMain;
import master.mod.MasterModMain;
import memdto.BookDTO;
import memdto.MemDTO;

public class MasterMemberController implements Initializable{
   DBCommon db = new DBCommon();
   static Parent root;
   MasterDelMain mdm = new MasterDelMain();
   MasterModMain mmm = new MasterModMain();
   static Parent root1 = null;
   static Parent root2 = null;
   static String id;
   int rs;
   MemDTO dto = new MemDTO();

   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      // TODO Auto-generated method stub
      
   }
   public void setRoot(Parent root) {
      this.root = root;
   }
   
   public void memberSearch() { //검색하기
      TextField searchId = (TextField)root.lookup("#memberSearchId");
      dto = memCheck(searchId.getText());   
      

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
               Label lbbook = (Label)root2.lookup("#lbbook");
               id=dto.getId();
               lb1.setText(dto.getId());
               lb12.setText(dto.getName());
               lb13.setText(dto.getPhone());
               lbbook.setText("대여 도서 목록");
               ComboBox<String> cmid = (ComboBox<String>)root2.lookup("#cmid");
               ArrayList<BookDTO> list = cm();
               if(cmid != null) {
                  for(int i = 0; i<list.size(); i++) {
                     cmid.getItems().addAll(list.get(i).getTitle());
                  }
               }
               
               Scene scene = new Scene(root2);
               
               
               
               stage.setScene(scene);
               stage.show();
               
            } else {
               db.getAlert("존재하지 않는 ID입니다.");
            }
   }
   
   public ArrayList<BookDTO> cm(){ //BOOK-List 
      ArrayList<BookDTO> list = new ArrayList<BookDTO>();
      try {
         PreparedStatement ps;
         ps = DBCommon.con.prepareStatement("select * from book where id='"+id+"'");
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            BookDTO dto = new BookDTO();
            dto.setTitle(rs.getString("title"));
            list.add(dto);
         }
      } catch (Exception e) {
         // TODO: handle exception
      }
      return list;  
   }
   
   public void memberBack() { //뒤로 
      db.closeStage(root);
   }
   
   public MemDTO memCheck(String id) { //id로 멤버 불러오기 
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
   
   public void del() { //마스터 멤버 삭제
		DBCommon.setDBConnection();
		PreparedStatement ps;

		try {
			ps = DBCommon.con.prepareStatement("delete from member where id = '"+id+"'");
			rs = ps.executeUpdate();

			if(rs == 1) {
				db.closeStage(root2);
				DBCommon.getAlert("삭제 성공");
			}else {
				DBCommon.getAlert("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
   
   public void mod() {	//마스터 멤버 수정
	   Stage stage = new Stage();   
       FXMLLoader loader = new FXMLLoader(getClass().getResource("memberMod.fxml"));
       Parent root1 = null;
       try {
			root1 = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
       
       	Label userid = (Label)root1.lookup("#userId");
		Label exname = (Label)root1.lookup("#exName");
		Label exphone = (Label)root1.lookup("#exPhone");
		
		MemDTO dto = new MemDTO();

		userid.setText(dto.getId());
		exname.setText(dto.getName());
		exphone.setText(dto.getPhone());
		
		MasterMemberModController mmmclt = loader.getController();
		mmmclt.setRoot(root1);
		
		Scene scene = new Scene(root1);
       
		stage.setScene(scene);
		stage.show();
   }
   
   public void back() {//뒤로
      db.closeStage(root2);
   }
}