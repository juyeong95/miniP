package Lee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

public static Connection dbConn;
public static Connection getConnection1() {

    Connection conn = null;

    try {
        String id = "g3"; 
        String pw = "1234";
        String url = "jdbc:mysql://localhost:3306/management?characterEncoding=UTF-8&&serverTimezone=UTC";
        //디배 내용 맞지 않음(다른 코드에서 인용)

        Class.forName("com.mysql.cj.jdbc.Driver");        
        conn = DriverManager.getConnection(url, id, pw);

        System.out.println("Database 연결 성공");

    } catch (Exception e) {
        System.out.println("Database 연결 실패");
        e.printStackTrace();
    }
    return conn;     
}

public static void close(PreparedStatement stmt, Connection conn) {
    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }

    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
    if (rs != null) {
        try {
            if (!rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }
    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void main(String[] args) {
    getConnection();
  }

public static Connection getConnection() {
	// TODO Auto-generated method stub
	return null;
}


}




