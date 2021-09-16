package dbcommon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCommon {
	public static Connection con;
	public static void setDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","g3","1234");
			System.out.println("연결 되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
