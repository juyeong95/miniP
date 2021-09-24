package dbcommon;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DBCommon {
	public static Connection con;
	static Parent root;
	public static void setDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","g3","1234");
			System.out.println("연결 되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getAlert(String msg) { //alert창 등록
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
	public static void closeStage(Parent root) {	//작업창 닫기 
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();	
	}
}
