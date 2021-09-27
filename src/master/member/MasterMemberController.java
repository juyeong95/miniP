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
import miniProject.LoginController;
import service.MyServiceImpl;

public class MasterMemberController implements Initializable{
   DBCommon db = new DBCommon();
   Parent root;
   MasterDelMain mdm = new MasterDelMain();
   MasterModMain mmm = new MasterModMain();
   static Parent root2 = null;
   static String id;

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
   public ArrayList<BookDTO> cm(){
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